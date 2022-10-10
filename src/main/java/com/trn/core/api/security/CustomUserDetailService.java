package com.trn.core.api.security;

import com.trn.core.api.entities.User;
import com.trn.core.api.exceptions.ResourceNotFoundException;
import com.trn.core.api.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //loading user from database by username
        User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User","email: "+username,0));

        return user;
    }
}
