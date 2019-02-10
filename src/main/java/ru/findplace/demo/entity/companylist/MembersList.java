package ru.findplace.demo.entity.companylist;

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
        "members",
        "list_id"
})
public class MembersList {

    @JsonProperty("members")
    private List<Member> members = null;
    @JsonProperty("list_id")
    private String listId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("members")
    public List<Member> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<Member> members) {
        this.members = members;
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