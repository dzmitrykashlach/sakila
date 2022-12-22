package com.mvc.components;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.mvcMatcher("/mvc/ui/payments/**")
                .authorizeRequests()
                .mvcMatchers("/mvc/ui/payments/**")
                .access("hasAuthority('SCOPE_paymentsa.read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}