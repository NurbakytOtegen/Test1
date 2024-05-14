package org.example.service.Impl;

import lombok.AllArgsConstructor;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.example.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    //Предыдущий метод
//    @Override
//    public UserDTO addUser(UserDTO userDTO) {
//        User user= UserMapper.mapToUser(userDTO);
//        User savedUser=userRepository.save(user);
//        return UserMapper.mapToUserDTO(savedUser);
//    }

    @Override
    public UserDTO addUser(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException(user.getUsername()+" уже существует");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException(user.getEmail()+" уже есть такой email");
        }
        User userA=userRepository.save(user);
        return UserMapper.mapToUserDTO(userA);
    }
    @Override
    public UserDTO getUserById(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User is not exist with given id: "+userId));
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users=userRepository.findAll();
        return users.stream().map((user) ->UserMapper.mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User is not exist with given id: "+userId));
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO updatedUser) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User is not exist with given id:"+userId));
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        User updatedUserObj=userRepository.save(user);
        return UserMapper.mapToUserDTO(updatedUserObj);
    }
    public  UserDTO updatePassword(long userId,String updatedPassword){
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not exist with given id: "+userId));
        user.setPassword(updatedPassword);
        User updPassword=userRepository.save(user);
        return UserMapper.mapToUserDTO(user);
    }
    public UserDetailsService userDetailsService(){
        return this::getByUsername;
    }

    @Override
    public User getByUsername(String username) {
       return userRepository.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("Пользователь не найден"));

    }
}
