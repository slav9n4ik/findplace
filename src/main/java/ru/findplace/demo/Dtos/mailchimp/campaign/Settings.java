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
        "subject_line",
        "preview_text",
        "title",
        "from_name",
        "reply_to",
        "use_conversation",
        "to_name",
        "folder_id",
        "authenticate",
        "auto_footer",
        "inline_css",
        "auto_tweet",
        "fb_comments",
        "timewarp",
        "template_id",
        "drag_and_drop"
})
public class Settings {

    @JsonProperty("subject_line")
    private String subjectLine;
    @JsonProperty("preview_text")
    private String previewText;
    @JsonProperty("title")
    private String title;
    @JsonProperty("from_name")
    private String fromName;
    @JsonProperty("reply_to")
    private String replyTo;
    @JsonProperty("use_conversation")
    private Boolean useConversation;
    @JsonProperty("to_name")
    private String toName;
    @JsonProperty("folder_id")
    private String folderId;
    @JsonProperty("authenticate")
    private Boolean authenticate;
    @JsonProperty("auto_footer")
    private Boolean autoFooter;
    @JsonProperty("inline_css")
    private Boolean inlineCss;
    @JsonProperty("auto_tweet")
    private Boolean autoTweet;
    @JsonProperty("fb_comments")
    private Boolean fbComments;
    @JsonProperty("timewarp")
    private Boolean timewarp;
    @JsonProperty("template_id")
    private Integer templateId;
    @JsonProperty("drag_and_drop")
    private Boolean dragAndDrop;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("subject_line")
    public String getSubjectLine() {
        return subjectLine;
    }

    @JsonProperty("subject_line")
    public void setSubjectLine(String subjectLine) {
        this.subjectLine = subjectLine;
    }

    @JsonProperty("preview_text")
    public String getPreviewText() {
        return previewText;
    }

    @JsonProperty("preview_text")
    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("from_name")
    public String getFromName() {
        return fromName;
    }

    @JsonProperty("from_name")
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @JsonProperty("reply_to")
    public String getReplyTo() {
        return replyTo;
    }

    @JsonProperty("reply_to")
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @JsonProperty("use_conversation")
    public Boolean getUseConversation() {
        return useConversation;
    }

    @JsonProperty("use_conversation")
    public void setUseConversation(Boolean useConversation) {
        this.useConversation = useConversation;
    }

    @JsonProperty("to_name")
    public String getToName() {
        return toName;
    }

    @JsonProperty("to_name")
    public void setToName(String toName) {
        this.toName = toName;
    }

    @JsonProperty("folder_id")
    public String getFolderId() {
        return folderId;
    }

    @JsonProperty("folder_id")
    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    @JsonProperty("authenticate")
    public Boolean getAuthenticate() {
        return authenticate;
    }

    @JsonProperty("authenticate")
    public void setAuthenticate(Boolean authenticate) {
        this.authenticate = authenticate;
    }

    @JsonProperty("auto_footer")
    public Boolean getAutoFooter() {
        return autoFooter;
    }

    @JsonProperty("auto_footer")
    public void setAutoFooter(Boolean autoFooter) {
        this.autoFooter = autoFooter;
    }

    @JsonProperty("inline_css")
    public Boolean getInlineCss() {
        return inlineCss;
    }

    @JsonProperty("inline_css")
    public void setInlineCss(Boolean inlineCss) {
        this.inlineCss = inlineCss;
    }

    @JsonProperty("auto_tweet")
    public Boolean getAutoTweet() {
        return autoTweet;
    }

    @JsonProperty("auto_tweet")
    public void setAutoTweet(Boolean autoTweet) {
        this.autoTweet = autoTweet;
    }

    @JsonProperty("fb_comments")
    public Boolean getFbComments() {
        return fbComments;
    }

    @JsonProperty("fb_comments")
    public void setFbComments(Boolean fbComments) {
        this.fbComments = fbComments;
    }

    @JsonProperty("timewarp")
    public Boolean getTimewarp() {
        return timewarp;
    }

    @JsonProperty("timewarp")
    public void setTimewarp(Boolean timewarp) {
        this.timewarp = timewarp;
    }

    @JsonProperty("template_id")
    public Integer getTemplateId() {
        return templateId;
    }

    @JsonProperty("template_id")
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @JsonProperty("drag_and_drop")
    public Boolean getDragAndDrop() {
        return dragAndDrop;
    }

    @JsonProperty("drag_and_drop")
    public void setDragAndDrop(Boolean dragAndDrop) {
        this.dragAndDrop = dragAndDrop;
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
