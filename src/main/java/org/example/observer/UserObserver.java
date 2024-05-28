package org.example.observer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserObserver implements Observer{
    private String username;
    private String email;

//    private JavaMailSender mailSender;

    public UserObserver(String username, String email){
        this.username=username;
        this.email=email;
//        this.mailSender=javaMailSender;
    }
    @Override
    public void update(Long movieId, double newRating) {
        System.out.println("Dear "+username+", the movie "+movieId+" has a new rating "+newRating+"! Notification sent to "+email);
//        sendEmailNotification(movieId, newRating);
    }

//    private void sendEmailNotification(Long movieId, double newRating){
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom("notegen6@gmail.com");
//            message.setTo(email);
//            message.setSubject("New Rating for " + movieId);
//            message.setText("Dear " + username + ",\n\nThe movie " + movieId + " has a new rating of " + newRating + ".\n\nBest regards,\nMovie Subscription Service");
//
//            mailSender.send(message);
//            System.out.println("Email notification sent successfully to " + email);
//        } catch (MailException e) {
//            System.out.println("Failed to send email notification to " + email + ": " + e.getMessage());
//        }
//    }
}
