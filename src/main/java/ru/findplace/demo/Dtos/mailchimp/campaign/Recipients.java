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
        "list_id",
        "list_is_active",
        "list_name",
        "segment_text",
        "recipient_count"
})
public class Recipients {

    @JsonProperty("list_id")
    private String listId;
    @JsonProperty("list_is_active")
    private Boolean listIsActive;
    @JsonProperty("list_name")
    private String listName;
    @JsonProperty("segment_text")
    private String segmentText;
    @JsonProperty("recipient_count")
    private Integer recipientCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("list_id")
    public String getListId() {
        return listId;
    }

    @JsonProperty("list_id")
    public void setListId(String listId) {
        this.listId = listId;
    }

    @JsonProperty("list_is_active")
    public Boolean getListIsActive() {
        return listIsActive;
    }

    @JsonProperty("list_is_active")
    public void setListIsActive(Boolean listIsActive) {
        this.listIsActive = listIsActive;
    }

    @JsonProperty("list_name")
    public String getListName() {
        return listName;
    }

    @JsonProperty("list_name")
    public void setListName(String listName) {
        this.listName = listName;
    }

    @JsonProperty("segment_text")
    public String getSegmentText() {
        return segmentText;
    }

    @JsonProperty("segment_text")
    public void setSegmentText(String segmentText) {
        this.segmentText = segmentText;
    }

    @JsonProperty("recipient_count")
    public Integer getRecipientCount() {
        return recipientCount;
    }

    @JsonProperty("recipient_count")
    public void setRecipientCount(Integer recipientCount) {
        this.recipientCount = recipientCount;
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