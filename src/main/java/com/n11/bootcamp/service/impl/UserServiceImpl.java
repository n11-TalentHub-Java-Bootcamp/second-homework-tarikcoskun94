package com.n11.bootcamp.service.impl;

import com.n11.bootcamp.dao.UserDao;
import com.n11.bootcamp.dto.UserDTO;
import com.n11.bootcamp.entity.User;
import com.n11.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<UserDTO> findAllUsers() {

        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            userDTOList.add(UserDTO.convertUserToUserDTO(user));
        }

        return userDTOList;
    }

    @Override
    public UserDTO findUserByUsername(String username) {

        User user = userDao.findByUsername(username).orElseThrow(() -> new RuntimeException("User is not found by username."));

        return UserDTO.convertUserToUserDTO(user);
    }

    @Override
    public UserDTO findByPhoneNumber(String phoneNumber) {

        User user = userDao.findByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("User is not found by phone number."));

        return UserDTO.convertUserToUserDTO(user);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        User requestUser = UserDTO.convertUserDTOToUser(userDTO);
        User responseUser = userDao.save(requestUser);

        return UserDTO.convertUserToUserDTO(responseUser);
    }

    @Override
    @Transactional
    public void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber) {

        userDao.findByUsernameAndPhoneNumber(username, phoneNumber).orElseThrow(() -> new RuntimeException("User is not found by username and phone number."));
        userDao.deleteUserByUsernameAndPhoneNumber(username, phoneNumber);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {

        User requestUser = UserDTO.convertUserDTOToUser(userDTO);
        User responseUser = userDao.save(requestUser);

        return UserDTO.convertUserToUserDTO(responseUser);
    }
}
