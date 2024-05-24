package org.example.service.Impl;

import lombok.AllArgsConstructor;
import org.example.Payments.PaymentMethod;
import org.example.Payments.PaymentMethodDto;
import org.example.Payments.PaymentStrategy;
import org.example.Payments.PaymentStrategyFactory;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Override
    public void addPaymentMethod(Long userId, PaymentMethodDto paymentMethodDto) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User not found with given id: "+userId));

        PaymentMethod paymentMethod=new PaymentMethod();
        paymentMethod.setType(paymentMethodDto.getType());

        if("creditCard".equalsIgnoreCase(paymentMethodDto.getType())){
            paymentMethod.setCardNumber(paymentMethodDto.getCardNumber());
            paymentMethod.setCvv(paymentMethodDto.getCvv());
        }else if("paypal".equalsIgnoreCase(paymentMethod.getType())){
            paymentMethod.setPaypalEmail(paymentMethodDto.getPaypalEmail());
            paymentMethod.setPaypalPassword(paymentMethodDto.getPaypalPassword());
        }

        user.getPaymentMethod().add(paymentMethod);
        userRepository.save(user);
    }

    @Override
    public List<PaymentMethodDto> getPaymentMethods(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return user.getPaymentMethod().stream()
                .map(paymentMethod -> new PaymentMethodDto(
                        paymentMethod.getId(),
                        paymentMethod.getType(),
                        paymentMethod.getCardNumber(),
                        paymentMethod.getCvv(),
                        paymentMethod.getPaypalEmail(),
                        paymentMethod.getPaypalPassword()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public void topUpBalance(Long userId, double amount, Long paymentMethodId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User not found with given id: "+userId));

        PaymentMethod paymentMethod=user.getPaymentMethod().stream()
                .filter(pm->pm.getId().equals(paymentMethodId))
                .findFirst()
                .orElseThrow(()->new ResourceNotFoundException("Payment method not found with id: " + paymentMethodId));

        PaymentStrategy paymentStrategy= PaymentStrategyFactory.getPaymentStrategy(new PaymentMethodDto(
                paymentMethod.getId(),
                paymentMethod.getType(),
                paymentMethod.getCardNumber(),
                paymentMethod.getCvv(),
                paymentMethod.getPaypalEmail(),
                paymentMethod.getPaypalPassword()
        ));

        paymentStrategy.pay(amount);
        user.setBalance(user.getBalance()+amount);
        userRepository.save(user);
    }

    @Override
    public double getUserBalance(long id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not user for given id"));
        if (user!=null) {
            return user.getBalance();
        }
        return 0;
    }
}
