package org.example.mapper;

import org.example.dto.UserDTO;
import org.example.entity.User;


public class UserMapper {
    public static UserDTO mapToUserDTO(User user){

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getBalance(),
                user.getPaymentMethod()
        );
    }

    public static User mapToUser(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.getRole(),
                userDTO.getBalance(),
                userDTO.getPaymentMethod()
        );
    }
}
