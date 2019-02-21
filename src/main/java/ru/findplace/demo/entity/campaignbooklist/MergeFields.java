package ru.findplace.demo.entity.campaignbooklist;

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
        "FNAME",
        "LNAME",
        "PHONE",
        "BIRTHDAY"
})
public class MergeFields {

    @JsonProperty("FNAME")
    private String fNAME;
    @JsonProperty("LNAME")
    private String lNAME;
    @JsonProperty("PHONE")
    private String pHONE;
    @JsonProperty("BIRTHDAY")
    private String bIRTHDAY;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FNAME")
    public String getFNAME() {
        return fNAME;
    }

    @JsonProperty("FNAME")
    public void setFNAME(String fNAME) {
        this.fNAME = fNAME;
    }

    @JsonProperty("LNAME")
    public String getLNAME() {
        return lNAME;
    }

    @JsonProperty("LNAME")
    public void setLNAME(String lNAME) {
        this.lNAME = lNAME;
    }

    @JsonProperty("PHONE")
    public String getPHONE() {
        return pHONE;
    }

    @JsonProperty("PHONE")
    public void setPHONE(String pHONE) {
        this.pHONE = pHONE;
    }

    @JsonProperty("BIRTHDAY")
    public String getBIRTHDAY() {
        return bIRTHDAY;
    }

    @JsonProperty("BIRTHDAY")
    public void setBIRTHDAY(String bIRTHDAY) {
        this.bIRTHDAY = bIRTHDAY;
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