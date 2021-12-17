package com.n11.bootcamp.dto;

import com.n11.bootcamp.entity.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    public static UserDTO convertUserToUserDTO(User user) {

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static User convertUserDTOToUser(UserDTO userDTO) {

        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
