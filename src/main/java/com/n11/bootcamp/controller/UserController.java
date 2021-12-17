package com.n11.bootcamp.controller;

import com.n11.bootcamp.dto.UserDTO;
import com.n11.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {

        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDTO> findUserByUsername(@PathVariable(value = "username") String username) {

        return ResponseEntity.ok(userService.findUserByUsername(username));
    }
}
