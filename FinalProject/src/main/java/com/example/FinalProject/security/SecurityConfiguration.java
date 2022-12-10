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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeHttpRequests()

                //rutas a las que solo el admin tiene acceso

                .requestMatchers(HttpMethod.POST, "/account-admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/account-admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/account-admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/account-admin/**").hasRole("ADMIN")

                // rutas a las que solo el Account Holder puede acceder

                .requestMatchers(HttpMethod.POST, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.GET, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.PATCH, "/account-holder/**").hasRole("ACCOUNT_HOLDER")
                .requestMatchers(HttpMethod.PUT, "/transaction/receive/account-id/{accountId}/account-destination/{accountDestination}/money/{money}").hasRole("ACCOUNT_HOLDER")

                // rutas a las que solo el third party puede acceder

                .requestMatchers(HttpMethod.POST, "/thirdparty-account/**").hasRole("THIRD_PARTY")
                .requestMatchers(HttpMethod.PUT, "/transaction/send/account-id/{accountId}/money/{money}/hashkey/{hashKey}**").hasRole("THIRD_PARTY")
                .requestMatchers(HttpMethod.PUT, "/transaction/receive/account-id/{accountId}/money/{money}").hasRole("THIRD_PARTY")

                // rutas para el checking account
                .requestMatchers(HttpMethod.POST, "/checking-accounts/add").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/checking-accounts/add").hasRole("ACCOUNT_HOLDER")

                // rutas para el credit card

                .requestMatchers(HttpMethod.POST, "/creditcard-accounts/add").hasRole("ACCOUNT_HOLDER")

                // rutas para el saving account

                .requestMatchers(HttpMethod.POST, "/saving-accounts/add").hasRole("ACCOUNT_HOLDER")

                // rutas para el student checking

                .requestMatchers(HttpMethod.POST, "/student-accounts/add").hasRole("ACCOUNT_HOLDER")

                .anyRequest().permitAll();
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
