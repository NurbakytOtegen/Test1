package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.ERole;

@Data


public class RegistrationDto {

    private String username;
    private String email;
    private String password;
    private ERole role;

}
