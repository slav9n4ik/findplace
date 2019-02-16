package ru.findplace.demo.entity.template;

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
        "templates",
        "total_items"
})
public class TemplateList {

    @JsonProperty("templates")
    private List<Template> templates = null;
    @JsonProperty("total_items")
    private Integer totalItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("templates")
    public List<Template> getTemplates() {
        return templates;
    }

    @JsonProperty("templates")
    public void setTemplates(List<Template> templates) {
        this.templates = templates;
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
