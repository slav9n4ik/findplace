package ru.findplace.demo.entity.campaign;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "opens",
        "unique_opens",
        "open_rate",
        "clicks",
        "subscriber_clicks",
        "click_rate",
        "ecommerce"
})
public class ReportSummary {

    @JsonProperty("opens")
    private Integer opens;
    @JsonProperty("unique_opens")
    private Integer uniqueOpens;
    @JsonProperty("open_rate")
    private Double openRate;
    @JsonProperty("clicks")
    private Integer clicks;
    @JsonProperty("subscriber_clicks")
    private Integer subscriberClicks;
    @JsonProperty("click_rate")
    private Integer clickRate;
    @JsonProperty("ecommerce")
    private Ecommerce ecommerce;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("opens")
    public Integer getOpens() {
        return opens;
    }

    @JsonProperty("opens")
    public void setOpens(Integer opens) {
        this.opens = opens;
    }

    @JsonProperty("unique_opens")
    public Integer getUniqueOpens() {
        return uniqueOpens;
    }

    @JsonProperty("unique_opens")
    public void setUniqueOpens(Integer uniqueOpens) {
        this.uniqueOpens = uniqueOpens;
    }

    @JsonProperty("open_rate")
    public Double getOpenRate() {
        return openRate;
    }

    @JsonProperty("open_rate")
    public void setOpenRate(Double openRate) {
        this.openRate = openRate;
    }

    @JsonProperty("clicks")
    public Integer getClicks() {
        return clicks;
    }

    @JsonProperty("clicks")
    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    @JsonProperty("subscriber_clicks")
    public Integer getSubscriberClicks() {
        return subscriberClicks;
    }

    @JsonProperty("subscriber_clicks")
    public void setSubscriberClicks(Integer subscriberClicks) {
        this.subscriberClicks = subscriberClicks;
    }

    @JsonProperty("click_rate")
    public Integer getClickRate() {
        return clickRate;
    }

    @JsonProperty("click_rate")
    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    @JsonProperty("ecommerce")
    public Ecommerce getEcommerce() {
        return ecommerce;
    }

    @JsonProperty("ecommerce")
    public void setEcommerce(Ecommerce ecommerce) {
        this.ecommerce = ecommerce;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}