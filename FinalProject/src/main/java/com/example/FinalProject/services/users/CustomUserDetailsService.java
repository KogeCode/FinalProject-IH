package com.example.FinalProject.services.users;

import com.example.FinalProject.models.*;
import com.example.FinalProject.models.users.User;
import com.example.FinalProject.repositories.users.UserRepository;
import com.example.FinalProject.security.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("El usuario no existe");
        }

        return new CustomUserDetails(user.get());

    }
}
