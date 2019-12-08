package ua.biedin.blog.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.biedin.blog.repository.entity.UserRole;
import ua.biedin.blog.repository.entity.UserStatus;

@Data
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
    private UserRole role;
    private String password;
}

