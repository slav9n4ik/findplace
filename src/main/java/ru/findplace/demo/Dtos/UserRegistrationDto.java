package ru.findplace.demo.Dtos;

import lombok.Getter;
import lombok.Setter;
import ru.findplace.demo.entity.Interest;
import ru.findplace.demo.utils.FieldMatch;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
@Getter
@Setter
public class UserRegistrationDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

    private List<Interest> interests;
}
