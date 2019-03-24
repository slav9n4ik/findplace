package ru.findplace.demo.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class UpdateUserDto {
    @NotEmpty
    private String login;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String email;
}
