package com.n11.bootcamp.controller;

import com.n11.bootcamp.dto.UserDTO;
import com.n11.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/with-username/{username}")
    public ResponseEntity<UserDTO> findUserByUsername(@PathVariable String username) {

        return ResponseEntity.ok(userService.findUserByUsername(username));
    }

    @GetMapping(value = "/with-phone-number/{phoneNumber}")
    public ResponseEntity<UserDTO> findUserByPhoneNumber(@PathVariable String phoneNumber) {

        return ResponseEntity.ok(userService.findByPhoneNumber(phoneNumber));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        // TODO: Search usage of URI and modify this response by using created function.
        return new ResponseEntity<UserDTO>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUserByUsernameAndPhoneNumber(@RequestParam(value = "username") String username, @RequestParam(value = "phone-number") String phoneNumber) {

        userService.deleteUserByUsernameAndPhoneNumber(username, phoneNumber);
        String responseMessage = "User that called '" + username + "' has been deleted";

        return ResponseEntity.ok(responseMessage);
    }
}
