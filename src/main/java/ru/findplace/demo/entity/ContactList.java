package ru.findplace.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactList {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String listName;
}
