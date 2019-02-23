package ru.findplace.demo.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.findplace.demo.entity.Interest;

import java.util.Set;

@Getter
@Setter
@ToString
public class UserRequestDto {
    private String login;
    private String email;
    private String city;
    private String phone;
    private Set<Interest> interests;
}
