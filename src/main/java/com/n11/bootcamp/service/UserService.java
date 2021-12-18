package com.n11.bootcamp.service;

import com.n11.bootcamp.dto.UserDTO;

import java.util.List;


public interface UserService {

    List<UserDTO> findAllUsers();

    UserDTO findUserByUsername(String username);

    UserDTO findByPhoneNumber(String phoneNumber);

    UserDTO saveUser(UserDTO userDTO);

    void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber);

    UserDTO updateUser(UserDTO userDTO);
}
