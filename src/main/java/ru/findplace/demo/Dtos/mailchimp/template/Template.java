package ru.findplace.demo.Dtos.mailchimp.template;

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
        "type",
        "name",
        "drag_and_drop",
        "responsive",
        "category",
        "date_created",
        "date_edited",
        "created_by",
        "edited_by",
        "active",
        "thumbnail",
        "share_url"
})
public class Template {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("drag_and_drop")
    private Boolean dragAndDrop;
    @JsonProperty("responsive")
    private Boolean responsive;
    @JsonProperty("category")
    private String category;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_edited")
    private String dateEdited;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("edited_by")
    private String editedBy;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("share_url")
    private String shareUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("drag_and_drop")
    public Boolean getDragAndDrop() {
        return dragAndDrop;
    }

    @JsonProperty("drag_and_drop")
    public void setDragAndDrop(Boolean dragAndDrop) {
        this.dragAndDrop = dragAndDrop;
    }

    @JsonProperty("responsive")
    public Boolean getResponsive() {
        return responsive;
    }

    @JsonProperty("responsive")
    public void setResponsive(Boolean responsive) {
        this.responsive = responsive;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("date_edited")
    public String getDateEdited() {
        return dateEdited;
    }

    @JsonProperty("date_edited")
    public void setDateEdited(String dateEdited) {
        this.dateEdited = dateEdited;
    }

    @JsonProperty("created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("edited_by")
    public String getEditedBy() {
        return editedBy;
    }

    @JsonProperty("edited_by")
    public void setEditedBy(String editedBy) {
        this.editedBy = editedBy;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("share_url")
    public String getShareUrl() {
        return shareUrl;
    }

    @JsonProperty("share_url")
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
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
