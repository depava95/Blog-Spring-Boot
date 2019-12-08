package ua.biedin.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.biedin.blog.controller.dto.UserDTO;
import ua.biedin.blog.repository.entity.User;
import ua.biedin.blog.service.impl.LoginServiceImpl;
import ua.biedin.blog.service.impl.UserServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/user", produces = "application/json")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final LoginServiceImpl loginServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, LoginServiceImpl loginServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.loginServiceImpl = loginServiceImpl;
    }

    @GetMapping
    public Page<User> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "create") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
            Pageable pageable = UserServiceImpl.createPagination(size, page, sort, direction);
            return userServiceImpl.getAllUsers(pageable);
    }

    @GetMapping("/alive")
    public ResponseEntity<Page<User>> getAllUsersNotDeleted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "created_at") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        try {
            Pageable pageable = UserServiceImpl.createPagination(size, page, sort, direction);
            Page<User> allUsers = userServiceImpl.getAllUsersNotDeleted(pageable);
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deleted")
    public ResponseEntity<Page<User>> getAllUsersWhoDeleted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "created_at") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        try {
            Pageable pageable = UserServiceImpl.createPagination(size, page, sort, direction);
            Page<User> allUsers = userServiceImpl.getAllUsersDeleted(pageable);
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }



//    @GetMapping(value = "/{email}", produces = "application/json")
//    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
//        Optional<User> optionalUser = userServiceImpl.findUserByEmail(email);
//        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

//    @PostMapping
//    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
//        try {
//            UserDTO addUser = userServiceImpl.saveUser(user);
//            return new ResponseEntity<>(addUser, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


    //TODO CREATE UPDATING USER
//    @PatchMapping(path = "/{id}", consumes = "application/json")
//    public User updateUsername(@PathVariable long Id, @RequestBody User user) {
//        return ;
//    }


//    @PostMapping(value = "/login", consumes = "application/json")
//    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
//        LoginResponse loginResponse = loginServiceImpl.login(loginRequest.getLogin(), loginRequest.getPassword());
//        if (loginResponse.isLogin() && loginResponse.isPassword()) {
//            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
//        } else if (loginResponse.isLogin() && !loginResponse.isPassword()) {
//            return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
//        } else {
//            return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
//        }
//    }
}
