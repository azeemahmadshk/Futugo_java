package org.shopify.integrator.bonucci.service.config.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "success",
        "ARTICLE"
})

public class ArticleMain implements Serializable
{

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("ARTICLE")
    private List<Article> article = new ArrayList<Article>();
    private final static long serialVersionUID = 7967755115396338769L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ArticleMain() {
    }

    /**
     *
     * @param success
     * @param article
     */
    public ArticleMain(Boolean success, List<Article> article) {
        super();
        this.success = success;
        this.article = article;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("ARTICLE")
    public List<Article> getArticle() {
        return article;
    }

    @JsonProperty("ARTICLE")
    public void setArticle(List<Article> article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleMain that = (ArticleMain) o;
        return Objects.equals(success, that.success) && Objects.equals(article, that.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, article);
    }
}
