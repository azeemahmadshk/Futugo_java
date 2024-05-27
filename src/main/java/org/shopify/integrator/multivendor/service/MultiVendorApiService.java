package org.shopify.integrator.multivendor.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.shopify.integrator.multivendor.config.MultiVendorConfig;
import org.shopify.integrator.multivendor.dto.order.Order;
import org.shopify.integrator.multivendor.dto.order.OrderMultivendor;
import org.shopify.integrator.multivendor.dto.product.*;
import org.shopify.integrator.multivendor.dto.variant.VariantForUpdate;
import org.shopify.integrator.utils.Utils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultiVendorApiService {

    private static final Log LOG = LogFactory.getLog(MultiVendorApiService.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final MultiVendorConfig multiVendorConfig;

    public MultiVendorApiService(RestTemplate restTemplate, ObjectMapper objectMapper, MultiVendorConfig multiVendorConfig) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.multiVendorConfig = multiVendorConfig;
    }

    public ProductMultiVendorForRead post(ProductMultiVendorForPost dto, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products.json";
        HttpMethod method = HttpMethod.POST;

        try {
            printRequest(method.name(), url, dto);
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(dto, createHttpHeaders(token)), String.class);
            printResponse(method.name(), url, response.getBody(), response.getStatusCode().toString());
            return objectMapper.readValue(response.getBody(), ProductMultiVendorReadById.class).getProduct();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }


    public String updateProduct(ProductMultiVendorForUpdate dto, String productId, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products/" + productId + ".json";
        HttpMethod method = HttpMethod.PUT;

        try {
            printRequest(method.name(), url, dto);
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(dto, createHttpHeaders(token)), String.class);
            printResponse(method.name(), url, response.getBody(), response.getStatusCode().toString());
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    public ProductMultiVendorForRead getProduct(String productId, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products/" + productId + ".json";
        HttpMethod method = HttpMethod.GET;

        try {
            //printRequest(method.name(), url, "");
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders(token)), String.class);
            //printResponse(method.name(), url, response.getBody());
            return objectMapper.readValue(response.getBody(), ProductMultiVendorReadById.class).getProduct();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    public List<ProductMultiVendorForRead> getAllProducts(String token) {
        List<ProductMultiVendorForRead> results = new ArrayList();

        int page = 1;
        int size = 250;

        ProductMultiVendorList data;
        do {
            data = getAllProducts(page, size, token);
            results.addAll(data.getProducts());
            page += 1;
        } while (!CollectionUtils.isEmpty(data.getProducts()));

        return results;
    }


    public List<Order> getAllOrders(String token) {
        return getAllOrders(token, null);
    }


    public List<Order> getAllOrders(String token, String filter) {
        List<Order> results = new ArrayList();

        int page = 1;
        int size = 250;

        OrderMultivendor data;
        do {
            data = getAllOrders(page, size, token, filter);
            results.addAll(data.getOrders());
            page += 1;
        } while (!CollectionUtils.isEmpty(data.getOrders()));

        return results;
    }

    public void deleteAllProducts(String sellerId, String token) {
        int page = 1;
        int size = 250;

        ProductMultiVendorList data;
        do {
            data = getAllProducts(page, size, token);
            page += 1;

            data.getProducts().forEach(p -> {
                if (sellerId.equals(p.getSellerId())) {
                    deleteProduct(p.getId(), token);
                }
            });


        } while (!CollectionUtils.isEmpty(data.getProducts()));
    }

    public ProductMultiVendorList getAllProducts(int page, int limit, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products.json?page=" + page + "&limit=" + limit;
        HttpMethod method = HttpMethod.GET;

        try {
            //printRequest(method.name(), url, "");
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders(token)), String.class);
            //printResponse(method.name(), url, response.getBody());
            return objectMapper.readValue(response.getBody(), ProductMultiVendorList.class);

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    public OrderMultivendor getAllOrders(int page, int limit, String token, String filter) {
        Utils.sleep(multiVendorConfig.getDelay());



        UriComponentsBuilder builder  = UriComponentsBuilder.fromUriString(getEndpoint() + "/orders.json");
        builder.queryParam("page",page);
        builder.queryParam("limit",limit);

        if (StringUtils.isNotEmpty(filter)) {
            builder.queryParam("filter", filter);
        }

        HttpMethod method = HttpMethod.GET;

        try {
            printRequest(method.name(), builder.build().toUriString(), "");


           ResponseEntity<String> response = restTemplate.exchange(builder.build().toUri(), method, new HttpEntity<>(createHttpHeaders(token)), String.class);
            printResponse(method.name(), builder.build().toUriString(), response.getBody(), response.getStatusCode().toString());
            return objectMapper.readValue(response.getBody(), OrderMultivendor.class);


        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + builder.build().toUriString() + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }


    public String deleteProduct(String productId, String token) {
        Utils.sleep(multiVendorConfig.getDelay());
        String url = getEndpoint() + "/products/" + productId + ".json";
        HttpMethod method = HttpMethod.DELETE;

        try {
            printRequest(method.name(), url, "");
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders(token)), String.class);
            printResponse(method.name(), url, response.getBody(), response.getStatusCode().toString());
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    public String updateVariant(String productId, String variantId, VariantForUpdate variant, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products/" + productId + "/variants/" + variantId + ".json";
        HttpMethod method = HttpMethod.PUT;

        try {
            printRequest(method.name(), url, variant);
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(variant, createHttpHeaders(token)), String.class);
            printResponse(method.name(), url, response.getBody(), response.getStatusCode().toString());
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    public String deleteVariant(String productId, String variantId, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products/" + productId + "/variants/" + variantId + ".json";
        HttpMethod method = HttpMethod.DELETE;

        try {
            printRequest(method.name(), url, "");
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders(token)), String.class);
            printResponse(method.name(), url, response.getBody(), response.getStatusCode().toString());
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    public String postVariant(String productId, VariantForUpdate variant, String token) {
        Utils.sleep(multiVendorConfig.getDelay());

        String url = getEndpoint() + "/products/" + productId + "/variants.json";
        HttpMethod method = HttpMethod.POST;

        try {
            printRequest(method.name(), url, variant);
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(variant, createHttpHeaders(token)), String.class);
            printResponse(method.name(), url, response.getBody(), response.getStatusCode().toString());
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }

        throw new RuntimeException("Response contains no body");
    }

    private HttpHeaders createHttpHeaders(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

    private String getEndpoint() {
        return Utils.prepareEndpointRoot(multiVendorConfig.getEndpoint());
    }

    private void printRequest(String method, String url, Object body) throws JsonProcessingException {

        if (multiVendorConfig.isLogRequests()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\r\nMethod: " + method);
            sb.append("\r\nUrl: " + url + "\r\n");

            if (body instanceof String) {
                sb.append("Body: " + body);
            } else {
                sb.append("Body: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
            }
            LOG.info(sb.toString());
        }


    }

    private void printResponse(String method, String url, String resp, String statusCode) {

        if (multiVendorConfig.isLogRequests()) {
            LOG.info("Result for " + method + " " + url + " endpoint,\r\nStatus code:" + statusCode);
        }
    }

}
