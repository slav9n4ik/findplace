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
        "opens",
        "html_clicks",
        "text_clicks",
        "goal_tracking",
        "ecomm360",
        "google_analytics",
        "clicktale"
})
public class Tracking {

    @JsonProperty("opens")
    private Boolean opens;
    @JsonProperty("html_clicks")
    private Boolean htmlClicks;
    @JsonProperty("text_clicks")
    private Boolean textClicks;
    @JsonProperty("goal_tracking")
    private Boolean goalTracking;
    @JsonProperty("ecomm360")
    private Boolean ecomm360;
    @JsonProperty("google_analytics")
    private String googleAnalytics;
    @JsonProperty("clicktale")
    private String clicktale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("opens")
    public Boolean getOpens() {
        return opens;
    }

    @JsonProperty("opens")
    public void setOpens(Boolean opens) {
        this.opens = opens;
    }

    @JsonProperty("html_clicks")
    public Boolean getHtmlClicks() {
        return htmlClicks;
    }

    @JsonProperty("html_clicks")
    public void setHtmlClicks(Boolean htmlClicks) {
        this.htmlClicks = htmlClicks;
    }

    @JsonProperty("text_clicks")
    public Boolean getTextClicks() {
        return textClicks;
    }

    @JsonProperty("text_clicks")
    public void setTextClicks(Boolean textClicks) {
        this.textClicks = textClicks;
    }

    @JsonProperty("goal_tracking")
    public Boolean getGoalTracking() {
        return goalTracking;
    }

    @JsonProperty("goal_tracking")
    public void setGoalTracking(Boolean goalTracking) {
        this.goalTracking = goalTracking;
    }

    @JsonProperty("ecomm360")
    public Boolean getEcomm360() {
        return ecomm360;
    }

    @JsonProperty("ecomm360")
    public void setEcomm360(Boolean ecomm360) {
        this.ecomm360 = ecomm360;
    }

    @JsonProperty("google_analytics")
    public String getGoogleAnalytics() {
        return googleAnalytics;
    }

    @JsonProperty("google_analytics")
    public void setGoogleAnalytics(String googleAnalytics) {
        this.googleAnalytics = googleAnalytics;
    }

    @JsonProperty("clicktale")
    public String getClicktale() {
        return clicktale;
    }

    @JsonProperty("clicktale")
    public void setClicktale(String clicktale) {
        this.clicktale = clicktale;
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
