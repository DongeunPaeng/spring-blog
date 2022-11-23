package com.dongeunpaeng.springblog.config.auth;

import com.dongeunpaeng.springblog.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable();
        http.authorizeHttpRequests(req -> req
                .antMatchers("/", "/h2-console/**", "/css/**", "/js/**", "/images/**")
                .permitAll()
                .antMatchers("/api/v1/**")
                .hasRole(Role.USER.name())
                .anyRequest().authenticated());
        http.logout(logout -> logout.logoutSuccessUrl("/").permitAll());
        http.oauth2Login();
        return http.build();
    }
}
