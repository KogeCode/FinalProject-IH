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
                .requestMatchers(HttpMethod.POST, "/create-accountHolder").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/account-holder/add").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/checking-accounts/add").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/student-accounts/add").hasRole("")
                .requestMatchers(HttpMethod.POST, "/saving-accounts/add").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/creditcard-accounts/add").hasRole("ADMIN")


                .requestMatchers(HttpMethod.DELETE, "/thirdparty-account/delete").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/account-holder/delete").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.PUT, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.PATCH, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.DELETE, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.PUT, "/Receive/**").hasRole("ACCOUNT_HOLDER")
                //Ver como poner varios roles a un endpoint.

                .requestMatchers(HttpMethod.GET, "/account-admin**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/account-admin**").hasRole("ADMIN")

                .anyRequest().permitAll();
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
