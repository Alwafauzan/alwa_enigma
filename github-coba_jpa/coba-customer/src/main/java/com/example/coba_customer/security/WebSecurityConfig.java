// package com.example.coba_customer.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import
// org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.example.coba_customer.service.AppUserService;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {

// @Autowired
// private AppUserService appUserService;

// @Autowired
// private BCryptPasswordEncoder bCryptPasswordEncoder;

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// .csrf(csrf -> csrf.disable())
// .authorizeHttpRequests(authz -> authz
// .requestMatchers("/api/appuser/register").permitAll()
// .anyRequest().fullyAuthenticated())
// .httpBasic(basic -> {
// }); // Allows basic authentication

// return http.build();
// }

// @Bean
// public AuthenticationManager
// authenticationManager(AuthenticationConfiguration
// authenticationConfiguration)
// throws Exception {
// return authenticationConfiguration.getAuthenticationManager();
// }

// @Bean
// public DaoAuthenticationProvider daoAuthenticationProvider() {
// DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
// provider.setUserDetailsService(appUserService);
// provider.setPasswordEncoder(bCryptPasswordEncoder);
// return provider;
// }

// }
