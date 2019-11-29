package ua.biedin.blog.controller.request;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NonNull
    private String login;
    @Size(min = 8, message = "Маленький!")
    private String password;
}
