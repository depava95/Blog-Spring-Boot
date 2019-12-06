package ua.biedin.blog.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 8, max = 15, message = "Password must contain from 8 to 15 symbols")
    private String password;
}
