package com.example.FinalProject.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfiguration {

    @Bean
    PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/thirdparty-account/add").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/account-holder/add").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/thirdparty-account/delete").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/account-holder/delete").hasRole("ADMIN")
                .anyRequest().permitAll();
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}