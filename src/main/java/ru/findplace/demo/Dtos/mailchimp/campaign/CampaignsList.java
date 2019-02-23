package ru.findplace.demo.Dtos.mailchimp.campaign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "campaigns",
        "total_items"
})
public class CampaignsList {

    @JsonProperty("campaigns")
    private List<Campaign> campaigns = null;
    @JsonProperty("total_items")
    private Integer totalItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("campaigns")
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("campaigns")
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonProperty("total_items")
    public Integer getTotalItems() {
        return totalItems;
    }

    @JsonProperty("total_items")
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
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
