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
        "id",
        "email_address",
        "unique_email_id",
        "email_type",
        "status",
        "merge_fields",
        "stats",
        "ip_signup",
        "timestamp_signup",
        "ip_opt",
        "timestamp_opt",
        "member_rating",
        "last_changed",
        "language",
        "vip",
        "email_client",
        "tags_count",
        "tags",
        "list_id"
})
@ToString
public class Member {

    @JsonProperty("id")
    private String id;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("unique_email_id")
    private String uniqueEmailId;
    @JsonProperty("email_type")
    private String emailType;
    @JsonProperty("status")
    private String status;
    @JsonProperty("merge_fields")
    private MergeFields mergeFields;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("ip_signup")
    private String ipSignup;
    @JsonProperty("timestamp_signup")
    private String timestampSignup;
    @JsonProperty("ip_opt")
    private String ipOpt;
    @JsonProperty("timestamp_opt")
    private String timestampOpt;
    @JsonProperty("member_rating")
    private Integer memberRating;
    @JsonProperty("last_changed")
    private String lastChanged;
    @JsonProperty("language")
    private String language;
    @JsonProperty("vip")
    private Boolean vip;
    @JsonProperty("email_client")
    private String emailClient;
    @JsonProperty("tags_count")
    private Integer tagsCount;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("list_id")
    private String listId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("unique_email_id")
    public String getUniqueEmailId() {
        return uniqueEmailId;
    }

    @JsonProperty("unique_email_id")
    public void setUniqueEmailId(String uniqueEmailId) {
        this.uniqueEmailId = uniqueEmailId;
    }

    @JsonProperty("email_type")
    public String getEmailType() {
        return emailType;
    }

    @JsonProperty("email_type")
    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("merge_fields")
    public MergeFields getMergeFields() {
        return mergeFields;
    }

    @JsonProperty("merge_fields")
    public void setMergeFields(MergeFields mergeFields) {
        this.mergeFields = mergeFields;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("ip_signup")
    public String getIpSignup() {
        return ipSignup;
    }

    @JsonProperty("ip_signup")
    public void setIpSignup(String ipSignup) {
        this.ipSignup = ipSignup;
    }

    @JsonProperty("timestamp_signup")
    public String getTimestampSignup() {
        return timestampSignup;
    }

    @JsonProperty("timestamp_signup")
    public void setTimestampSignup(String timestampSignup) {
        this.timestampSignup = timestampSignup;
    }

    @JsonProperty("ip_opt")
    public String getIpOpt() {
        return ipOpt;
    }

    @JsonProperty("ip_opt")
    public void setIpOpt(String ipOpt) {
        this.ipOpt = ipOpt;
    }

    @JsonProperty("timestamp_opt")
    public String getTimestampOpt() {
        return timestampOpt;
    }

    @JsonProperty("timestamp_opt")
    public void setTimestampOpt(String timestampOpt) {
        this.timestampOpt = timestampOpt;
    }

    @JsonProperty("member_rating")
    public Integer getMemberRating() {
        return memberRating;
    }

    @JsonProperty("member_rating")
    public void setMemberRating(Integer memberRating) {
        this.memberRating = memberRating;
    }

    @JsonProperty("last_changed")
    public String getLastChanged() {
        return lastChanged;
    }

    @JsonProperty("last_changed")
    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("vip")
    public Boolean getVip() {
        return vip;
    }

    @JsonProperty("vip")
    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    @JsonProperty("email_client")
    public String getEmailClient() {
        return emailClient;
    }

    @JsonProperty("email_client")
    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @JsonProperty("tags_count")
    public Integer getTagsCount() {
        return tagsCount;
    }

    @JsonProperty("tags_count")
    public void setTagsCount(Integer tagsCount) {
        this.tagsCount = tagsCount;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("list_id")
    public String getListId() {
        return listId;
    }

    @JsonProperty("list_id")
    public void setListId(String listId) {
        this.listId = listId;
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