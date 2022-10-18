package com.trn.core.api.controllers;

import com.trn.core.api.payloads.JwtAuthRequest;
import com.trn.core.api.payloads.JwtAuthResponse;
import com.trn.core.api.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request
            ){
    this.authenticate(request.getUsername(),request.getPassword());

    UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
    String token = this.jwtTokenHelper.generateToken(userDetails);

    JwtAuthResponse response = new JwtAuthResponse();
    response.setToken(token);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        this.authenticationManager.authenticate(authenticationToken);
    }
}