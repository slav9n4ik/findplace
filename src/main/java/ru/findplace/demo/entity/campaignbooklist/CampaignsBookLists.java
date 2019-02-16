package ru.findplace.demo.entity.campaignbooklist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lists",
        "total_items"
})
@ToString
public class CampaignsBookLists {

    @JsonProperty("lists")
    private List<MembersBookList> lists = null;
    @JsonProperty("total_items")
    private Integer totalItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lists")
    public List<MembersBookList>  getLists() {
        return lists;
    }

    @JsonProperty("lists")
    public void setLists(List<MembersBookList>  lists) {
        this.lists = lists;
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