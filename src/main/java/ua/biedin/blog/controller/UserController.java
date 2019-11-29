package ua.biedin.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.biedin.blog.entity.User;
import ua.biedin.blog.service.UserService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/v1/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("api/v1/user/{id}")
    public User getUserById(@PathVariable Long id) {
       return userService.getUserById(id);
    }

    @PostMapping("api/v1/user")
    public ResponseEntity addUser (@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity("User added!", HttpStatus.ACCEPTED);
    }

}
