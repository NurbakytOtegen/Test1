package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.Payments.PaymentMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


}
