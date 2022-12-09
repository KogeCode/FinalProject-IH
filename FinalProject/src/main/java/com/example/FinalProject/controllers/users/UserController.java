package com.example.FinalProject.controllers.users;

import com.example.FinalProject.models.users.Role;
import com.example.FinalProject.models.users.User;
import com.example.FinalProject.repositories.users.RoleRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/create-accountHolder")
    public void createUser(@RequestBody User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        Role role = roleRepository.save(new Role("ACCOUNT_HOLDER", user));
    }

    @GetMapping("/user-details")
    public User getUserDetails(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(name = "id") Long id) {
        return userRepository.findByUsername(userDetails.getUsername()).get();
    }

}
