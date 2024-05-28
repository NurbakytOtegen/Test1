package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.UDecoder;
import org.example.Payments.PaymentMethodDto;
import org.example.Payments.TopUpRequest;
import org.example.dto.UserDTO;

import org.example.entity.User;
import org.example.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //Build give User By Id REST API
    @GetMapping("user_id={id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") long userId){
        UserDTO userDTO=userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }
    //Build give All Users REST API
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> users=userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    //Build delete User REST API
    @DeleteMapping("user_id={id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
    //Build update User REST API
    @PutMapping("user_id={id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long userId,@RequestBody UserDTO updatedUser){
        UserDTO userDTO=userService.updateUser(userId,updatedUser);
        return ResponseEntity.ok(userDTO);
    }
    //Build update Password REST API
    @PutMapping("forgot_password/user_id={id}")
    public ResponseEntity<UserDTO> updatePassword(
            @PathVariable("id") long userId,
            @RequestBody String updatedPassword){
            UserDTO userDTO = userService.updatePassword(userId, updatedPassword);
            return ResponseEntity.ok(userDTO);
    }


    @PostMapping("/{id}/payment")
    public ResponseEntity<Void> addPaymentMethod(@PathVariable("id") long id, @RequestBody PaymentMethodDto paymentMethodDto){
        userService.addPaymentMethod(id, paymentMethodDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/payment")
    public ResponseEntity<List<PaymentMethodDto>> getPaymentMethods(@PathVariable("id") long id){
        List<PaymentMethodDto> paymentMethods = userService.getPaymentMethods(id);
        return ResponseEntity.ok(paymentMethods);
    }


    @PostMapping("/{id}/balance")
    public ResponseEntity<Void> topUpBalance(@PathVariable("id") long id, @RequestBody TopUpRequest topUpRequest){
        userService.topUpBalance(id, topUpRequest.getAmount(), topUpRequest.getPaymentId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getUserBalance(
            @PathVariable("id") long id
    ){
        double balance = userService.getUserBalance(id);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/{userId}/subscribe/{movieId}")
    public ResponseEntity<String> subscribeToMovie(@PathVariable Long userId, @PathVariable Long movieId){
        userService.subscribeToMovie(userId, movieId);
        return ResponseEntity.ok("Subscription successful");
    }
    @PutMapping("/subscription/{subscriptionId}/{action}")
    public ResponseEntity<String> changeSubscriptionState(@PathVariable Long subscriptionId, @PathVariable String action){
        userService.changeSubscriptionState(subscriptionId, action);
        return ResponseEntity.ok("Subscription state successful updated");
    }


}
