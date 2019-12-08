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
import java.util.Optional;

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

    @GetMapping(produces = "application/json")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userById = userServiceImpl.getUserById(id);
        return userById.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/{email}", produces = "application/json")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> optionalUser = userServiceImpl.findUserByEmail(email);
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userServiceImpl.saveUser(user);
    }


    //TODO CREATE UPDATING USER
//    @PatchMapping(path = "/{id}", consumes = "application/json")
//    public User updateUsername(@PathVariable long Id, @RequestBody User user) {
//        return ;
//    }


    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginServiceImpl.login(loginRequest.getLogin(), loginRequest.getPassword());
        if (loginResponse.isLogin() && loginResponse.isPassword()) {
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        } else if (loginResponse.isLogin() && !loginResponse.isPassword()) {
            return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}
