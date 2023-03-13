package com.insy2sproj.secmicroservice.auth;

import com.insy2sproj.secmicroservice.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


    private String username;
    private String password;
    private Set<Role> roles;



}
