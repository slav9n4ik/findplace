package ru.findplace.demo.Dtos.mailchimp.campaign;

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
        "total_orders",
        "total_spent",
        "total_revenue"
})
public class Ecommerce {

    @JsonProperty("total_orders")
    private Integer totalOrders;
    @JsonProperty("total_spent")
    private Integer totalSpent;
    @JsonProperty("total_revenue")
    private Integer totalRevenue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total_orders")
    public Integer getTotalOrders() {
        return totalOrders;
    }

    @JsonProperty("total_orders")
    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    @JsonProperty("total_spent")
    public Integer getTotalSpent() {
        return totalSpent;
    }

    @JsonProperty("total_spent")
    public void setTotalSpent(Integer totalSpent) {
        this.totalSpent = totalSpent;
    }

    @JsonProperty("total_revenue")
    public Integer getTotalRevenue() {
        return totalRevenue;
    }

    @JsonProperty("total_revenue")
    public void setTotalRevenue(Integer totalRevenue) {
        this.totalRevenue = totalRevenue;
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
