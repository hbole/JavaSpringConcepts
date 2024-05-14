package com.example.springsecurityex.services;

import com.example.springsecurityex.models.User;
import com.example.springsecurityex.models.UserPrincipal;
import com.example.springsecurityex.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
