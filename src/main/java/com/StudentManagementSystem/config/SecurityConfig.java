package com.StudentManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.csrf(CsrfConfigurer<HttpSecurity> csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.POST, "/students").permitAll()
                                .requestMatchers("/students**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }

    @Bean
    UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder){
        UserDetails admin = User.withUsername("Admin")
                .roles("ADMIN")
                .password(PasswordEncoder.encode("pass123"))
                .build();

        UserDetails user = User.withUsername("Prashant")
                .roles("USER")
                .password(PasswordEncoder.encode("user123"))
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
