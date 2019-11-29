package ua.biedin.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.biedin.blog.controller.request.LoginRequest;
import ua.biedin.blog.controller.response.LoginResponse;
import ua.biedin.blog.repository.entity.User;
import ua.biedin.blog.service.impl.LoginServiceImpl;
import ua.biedin.blog.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final LoginServiceImpl loginServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, LoginServiceImpl loginServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.loginServiceImpl = loginServiceImpl;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        userServiceImpl.saveUser(user);
        return new ResponseEntity("User added!", HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest) {
        boolean isLogin = loginServiceImpl.login(loginRequest.getLogin(), loginRequest.getPassword());
        if (isLogin) {
            return new ResponseEntity<>(new LoginResponse(true, "Login success"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new LoginResponse(false, "Incorrect password"), HttpStatus.BAD_REQUEST);
        }
    }

}
