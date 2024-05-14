//package org.example.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.example.dto.UserDTO;
//import org.example.entity.Movie;
//import org.example.entity.User;
//import org.example.service.MovieService;
//import org.example.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("api/users")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//
//    //Build Add User REST API
//    @PostMapping("")
//    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
//        UserDTO savedUser=userService.addUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//    //Build give User By Id REST API
//    @GetMapping("user_id={id}")
//    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") long userId){
//        UserDTO userDTO=userService.getUserById(userId);
//        return ResponseEntity.ok(userDTO);
//    }
//    //Build give All Users REST API
//    @GetMapping("")
//    public ResponseEntity<List<UserDTO>> getAllUser(){
//        List<UserDTO> users=userService.getAllUser();
//        return ResponseEntity.ok(users);
//    }
//    //Build delete User REST API
//    @DeleteMapping("user_id={id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
//        userService.deleteUser(userId);
//        return ResponseEntity.ok("User deleted successfully");
//    }
//    //Build update User REST API
//    @PutMapping("user_id={id}")
//    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long userId,@RequestBody UserDTO updatedUser){
//        UserDTO userDTO=userService.updateUser(userId,updatedUser);
//        return ResponseEntity.ok(userDTO);
//    }
//    //Build update Password REST API
//    @PutMapping("forgot_password/user_id={id}")
//    public ResponseEntity<UserDTO> updatePassword(@PathVariable("id") long userId,@RequestBody String updatedPassword){
//        UserDTO userDTO=userService.updatePassword(userId,updatedPassword);
//        return ResponseEntity.ok(userDTO);
//    }
//}
