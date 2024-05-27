package org.shopify.integrator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {


    public static String prepareEndpointRoot(String url) {


        if (url == null) {
            return null;
        }
        return StringUtils.removeEnd(url.trim(), "/");

    }
    public static void sleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static String printObject(Object body) throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        return  om.writerWithDefaultPrettyPrinter().writeValueAsString(body);

    }

    public static String getMidnightDateString(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatter);
        return dateString + " 00:00:00";

    }

    public static String getCurrentDateString(){
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  currentDate.format(formatter);
    }

    public static DecimalFormat getDecimalFormatter(String format){

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        return new DecimalFormat(format, symbols);
    }
}
