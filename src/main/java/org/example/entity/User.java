package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {
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




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
