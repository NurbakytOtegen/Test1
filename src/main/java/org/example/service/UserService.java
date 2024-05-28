package org.example.service;


import org.example.Payments.PaymentMethodDto;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

//    UserDTO addUser(User user);
    UserDTO addUser(User user);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUser();
    void deleteUser(Long userId);
    UserDTO updateUser(long userId,UserDTO updatedUser);
    UserDTO updatePassword(long userId,String updatedPassword);

    UserDetailsService userDetailsService();
    User getByUsername(String username);


    //Добавить метод оплаты
    void addPaymentMethod(Long userId, PaymentMethodDto paymentMethodDto);
    List<PaymentMethodDto> getPaymentMethods(long id);

    //Пополнение баланса
    void topUpBalance(Long userId, double amount, Long paymentMethodId);

    double getUserBalance(long id);


    //////
    void subscribeToMovie(Long userId, Long movieId);

    void changeSubscriptionState(Long subscriptionId, String action);




//    private final UserRepository repository;

//    public UserService(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    public String addUser(User user){
//        if(!user.getLogin().isBlank() &&!user.getPassword().isBlank() && user.getLogin().length()>3 ){
//repository.save(user);
//            return "Added";
//        }
//        else return "Not Added";
//    }
//
//    public List<User> getAllUser(){
//        return repository.findAll();
//    }
//    public String createUser(User user){
//        if(!user.getUsername().isBlank()&& !user.getPassword().isBlank()){
//            repository.save(user);
//            return "added";
//        }
//        return "not added";
//    }


}
