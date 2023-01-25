package com.erich.codeando.config;

import com.erich.codeando.config.jwt.JwtAuthenticationFilter;
import com.erich.codeando.config.jwt.JwtConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtConfig jwtConfig;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        http.cors().disable().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests().requestMatchers("/api/v1/auth/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .authenticationProvider(jwtConfig.authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
