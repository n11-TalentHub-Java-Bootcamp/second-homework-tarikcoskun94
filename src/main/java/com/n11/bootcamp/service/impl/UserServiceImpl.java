package com.n11.bootcamp.service.impl;

import com.n11.bootcamp.dao.UserDAO;
import com.n11.bootcamp.dto.UserDTO;
import com.n11.bootcamp.entity.User;
import com.n11.bootcamp.exception.ApiRequestException;
import com.n11.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<UserDTO> findAllUsers() {

        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userDAO.findAll();

        for (User user : userList) {
            userDTOList.add(UserDTO.convertUserToUserDTO(user));
        }

        return userDTOList;
    }

    @Override
    public UserDTO findUserByUsername(String username) {

        User user = userDAO.findByUsername(username).orElseThrow(() -> new ApiRequestException("User is not found by username."));

        return UserDTO.convertUserToUserDTO(user);
    }

    @Override
    public UserDTO findByPhoneNumber(String phoneNumber) {

        User user = userDAO.findByPhoneNumber(phoneNumber).orElseThrow(() -> new ApiRequestException("User is not found by phone number."));

        return UserDTO.convertUserToUserDTO(user);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        User requestUser = UserDTO.convertUserDTOToUser(userDTO);
        User responseUser = userDAO.save(requestUser);

        return UserDTO.convertUserToUserDTO(responseUser);
    }

    @Override
    @Transactional
    public void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber) {

        userDAO.findByUsernameAndPhoneNumber(username, phoneNumber).orElseThrow(() -> new ApiRequestException("User is not found by username and phone number."));
        userDAO.deleteUserByUsernameAndPhoneNumber(username, phoneNumber);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {

        User requestUser = UserDTO.convertUserDTOToUser(userDTO);
        User responseUser = userDAO.save(requestUser);

        return UserDTO.convertUserToUserDTO(responseUser);
    }
}
