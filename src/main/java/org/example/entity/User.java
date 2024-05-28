package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.example.Payments.PaymentMethod;
import org.example.observer.Observer;
import org.example.observer.UserObserver;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "subscriptions"})
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "username",unique = true,nullable = false)
    private String username;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",unique = true,nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private ERole role;
    @Column(name="balance")
    private double balance;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<PaymentMethod> paymentMethod=new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Subscription> subscriptions=new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                ", paymentMethod=" + paymentMethod +
                ", subscriptions=" + subscriptions +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}


    public void addSubscription(Subscription subscription){
        subscriptions.add(subscription);
        subscription.setUser(this);
    }


    public void removeSubscription(Subscription subscription){
        subscriptions.remove(subscription);
        subscription.setUser(null);
    }

    public Observer createObserver(){
        return new UserObserver(this.username, this.email);
    }
}
