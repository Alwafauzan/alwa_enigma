package com.livecode.livecode_loan_app.config;

import static com.livecode.livecode_loan_app.model.Permission.*;
import static com.livecode.livecode_loan_app.model.Role.*;
import static org.springframework.http.HttpMethod.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
        private final JwtAuthFilter jwtAuthFilter;
        private final AuthenticationProvider authenticationProvider;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/api/v1/auth/**")
                                                .permitAll()

                                                // ADMIN ENDPOINTS
                                                .requestMatchers("/api/v1/admin/**")
                                                .hasAnyRole(STAFF.name(), ADMIN.name())
                                                .requestMatchers(GET, "/api/v1/admin/**")
                                                .hasAnyAuthority(STAFF_READ.name(), ADMIN_READ.name())
                                                .requestMatchers(POST, "/api/v1/admin/**")
                                                .hasAnyAuthority(STAFF_CREATE.name(), ADMIN_CREATE.name())
                                                .requestMatchers(PUT, "/api/v1/admin/**")
                                                .hasAnyAuthority(STAFF_UPDATE.name(), ADMIN_UPDATE.name())
                                                .requestMatchers(DELETE, "/api/v1/admin/**")
                                                .hasAnyAuthority(STAFF_DELETE.name(), ADMIN_DELETE.name())

                                                // STAFF ENDPOINTS
                                                .requestMatchers("/api/v1/staff/**").hasRole(STAFF.name())
                                                .requestMatchers(GET, "/api/v1/staff/**")
                                                .hasAuthority(STAFF_READ.name())
                                                .requestMatchers(POST, "/api/v1/staff/**")
                                                .hasAuthority(STAFF_CREATE.name())
                                                .requestMatchers(PUT, "/api/v1/staff/**")
                                                .hasAuthority(STAFF_UPDATE.name())
                                                .requestMatchers(DELETE, "/api/v1/staff/**")
                                                .hasAuthority(STAFF_DELETE.name())

                                                // CUSTOMER ENDPOINTS
                                                .requestMatchers("/api/v1/customer/**").hasRole(CUSTOMER.name())
                                                .requestMatchers(GET, "/api/v1/customer/**")
                                                .hasAuthority(CUSTOMER_READ.name())
                                                .requestMatchers(POST, "/api/v1/customer/**")
                                                .hasAuthority(CUSTOMER_CREATE.name())
                                                .requestMatchers(PUT, "/api/v1/customer/**")
                                                .hasAuthority(CUSTOMER_UPDATE.name())
                                                .requestMatchers(DELETE, "/api/v1/customer/**")
                                                .hasAuthority(CUSTOMER_DELETE.name())

                                                .anyRequest()
                                                .authenticated())
                                .sessionManagement((session) -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}
