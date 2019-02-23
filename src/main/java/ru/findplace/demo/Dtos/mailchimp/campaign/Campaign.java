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
        "id",
        "web_id",
        "type",
        "create_time",
        "archive_url",
        "long_archive_url",
        "status",
        "emails_sent",
        "send_time",
        "content_type",
        "needs_block_refresh",
        "has_logo_merge_tag",
        "resendable",
        "recipients",
        "settings",
        "tracking",
        "delivery_status",
        "social_card",
        "report_summary"
})
public class Campaign {

    @JsonProperty("id")
    private String id;
    @JsonProperty("web_id")
    private Integer webId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("archive_url")
    private String archiveUrl;
    @JsonProperty("long_archive_url")
    private String longArchiveUrl;
    @JsonProperty("status")
    private String status;
    @JsonProperty("emails_sent")
    private Integer emailsSent;
    @JsonProperty("send_time")
    private String sendTime;
    @JsonProperty("content_type")
    private String contentType;
    @JsonProperty("needs_block_refresh")
    private Boolean needsBlockRefresh;
    @JsonProperty("has_logo_merge_tag")
    private Boolean hasLogoMergeTag;
    @JsonProperty("resendable")
    private Boolean resendable;
    @JsonProperty("recipients")
    private Recipients recipients;
    @JsonProperty("settings")
    private Settings settings;
    @JsonProperty("tracking")
    private Tracking tracking;
    @JsonProperty("delivery_status")
    private DeliveryStatus deliveryStatus;
    @JsonProperty("social_card")
    private SocialCard socialCard;
    @JsonProperty("report_summary")
    private ReportSummary reportSummary;
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

    @JsonProperty("web_id")
    public Integer getWebId() {
        return webId;
    }

    @JsonProperty("web_id")
    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("create_time")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("create_time")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("archive_url")
    public String getArchiveUrl() {
        return archiveUrl;
    }

    @JsonProperty("archive_url")
    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    @JsonProperty("long_archive_url")
    public String getLongArchiveUrl() {
        return longArchiveUrl;
    }

    @JsonProperty("long_archive_url")
    public void setLongArchiveUrl(String longArchiveUrl) {
        this.longArchiveUrl = longArchiveUrl;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("emails_sent")
    public Integer getEmailsSent() {
        return emailsSent;
    }

    @JsonProperty("emails_sent")
    public void setEmailsSent(Integer emailsSent) {
        this.emailsSent = emailsSent;
    }

    @JsonProperty("send_time")
    public String getSendTime() {
        return sendTime;
    }

    @JsonProperty("send_time")
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @JsonProperty("content_type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("content_type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("needs_block_refresh")
    public Boolean getNeedsBlockRefresh() {
        return needsBlockRefresh;
    }

    @JsonProperty("needs_block_refresh")
    public void setNeedsBlockRefresh(Boolean needsBlockRefresh) {
        this.needsBlockRefresh = needsBlockRefresh;
    }

    @JsonProperty("has_logo_merge_tag")
    public Boolean getHasLogoMergeTag() {
        return hasLogoMergeTag;
    }

    @JsonProperty("has_logo_merge_tag")
    public void setHasLogoMergeTag(Boolean hasLogoMergeTag) {
        this.hasLogoMergeTag = hasLogoMergeTag;
    }

    @JsonProperty("resendable")
    public Boolean getResendable() {
        return resendable;
    }

    @JsonProperty("resendable")
    public void setResendable(Boolean resendable) {
        this.resendable = resendable;
    }

    @JsonProperty("recipients")
    public Recipients getRecipients() {
        return recipients;
    }

    @JsonProperty("recipients")
    public void setRecipients(Recipients recipients) {
        this.recipients = recipients;
    }

    @JsonProperty("settings")
    public Settings getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @JsonProperty("tracking")
    public Tracking getTracking() {
        return tracking;
    }

    @JsonProperty("tracking")
    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    @JsonProperty("delivery_status")
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    @JsonProperty("delivery_status")
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @JsonProperty("social_card")
    public SocialCard getSocialCard() {
        return socialCard;
    }

    @JsonProperty("social_card")
    public void setSocialCard(SocialCard socialCard) {
        this.socialCard = socialCard;
    }

    @JsonProperty("report_summary")
    public ReportSummary getReportSummary() {
        return reportSummary;
    }

    @JsonProperty("report_summary")
    public void setReportSummary(ReportSummary reportSummary) {
        this.reportSummary = reportSummary;
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