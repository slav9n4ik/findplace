package ru.findplace.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CompanyLists {
    @JsonProperty("lists")
    private List<ContactList> contactList;
}
