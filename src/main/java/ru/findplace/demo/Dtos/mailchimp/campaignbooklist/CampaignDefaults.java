package ru.findplace.demo.Dtos.mailchimp.campaignbooklist;

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
        "from_name",
        "from_email",
        "subject",
        "language"
})
public class CampaignDefaults {

    @JsonProperty("from_name")
    private String fromName;
    @JsonProperty("from_email")
    private String fromEmail;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("language")
    private String language;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("from_name")
    public String getFromName() {
        return fromName;
    }

    @JsonProperty("from_name")
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @JsonProperty("from_email")
    public String getFromEmail() {
        return fromEmail;
    }

    @JsonProperty("from_email")
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
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