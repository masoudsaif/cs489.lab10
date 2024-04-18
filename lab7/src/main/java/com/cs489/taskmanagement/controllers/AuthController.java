package com.cs489.taskmanagement.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.cs489.taskmanagement.model.User;
import com.cs489.taskmanagement.requests.AuthenticationRequest;
import com.cs489.taskmanagement.responses.AuthenticationResponse;
import com.cs489.taskmanagement.services.UserService;
import com.cs489.taskmanagement.utility.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        // Authenticate the user
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        // Fetch user details using the custom UserDetailsService
        User user = (User) userDetailsService.loadUserByEmail(request.getEmail());
        
        // Generate JWT token using the user's username
        String jwt = jwtTokenUtil.generateToken(user.getEmail());
        
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
