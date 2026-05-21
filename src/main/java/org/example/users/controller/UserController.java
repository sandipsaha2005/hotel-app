package org.example.users.controller;

import org.example.users.dto.LoginResponse;
import org.example.users.dto.RegisterResponse;
import org.example.users.dto.UserDto;
import org.example.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody UserDto user) {
        RegisterResponse response = userService.register(user);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDto user) {
        LoginResponse loginResponse = userService.login(user);
        return ResponseEntity.ok().body(loginResponse);
    }
}
