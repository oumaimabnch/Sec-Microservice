package com.insy2sproj.secmicroservice.auth;
import com.insy2sproj.secmicroservice.Repositories.RoleRepo;
import com.insy2sproj.secmicroservice.Repositories.UserRepo;
import com.insy2sproj.secmicroservice.config.JwtService;
import com.insy2sproj.secmicroservice.entities.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo repository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private  final PasswordEncoder passwordEncoder;
    @Autowired
    private  JavaMailSender mailSender;


    public AuthenticationResponse register(RegisterRequest request)  {
        String temporaryPassword = UUID.randomUUID().toString();
        // Create the new user with the provided email and temporary password

        var user =User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(temporaryPassword))
                .roles(request.getRoles())
                .build();

        repository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getUsername());
        message.setSubject("Temporary Password");
        message.setText(" Dear User,\n" +
                "\n" +
                "You have been given a temporary password to login to your account." +
                " For security reasons, we strongly recommend that you change this temporary password to a new, " +
                "permanent password as soon as possible.Your temporary password is: " + temporaryPassword );
        mailSender.send(message);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      request.getUsername(),
                      request.getPassword()
              )
      );
      var user= repository.findByUsername(request.getUsername())
              .orElseThrow();
      var jwtToken = jwtService.generateToken(user);
      return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();
    }
}
