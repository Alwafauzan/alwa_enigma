// package com.example.coba_customer.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.coba_customer.model.AppUser;
// import com.example.coba_customer.repository.AppUserRepository;

// import jakarta.transaction.Transactional;

// @Service
// @Transactional
// public class AppUserService implements UserDetailsService {

// @Autowired
// private AppUserRepository appUserRepository;

// @Autowired
// private BCryptPasswordEncoder bCryptPasswordEncoder;

// @Override
// public UserDetails loadUserByUsername(String username) throws
// UsernameNotFoundException {
// return appUserRepository.findByUsername(username)
// .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not
// found", username)));
// }

// public AppUser registerAppUser(AppUser user) {

// boolean exists =
// appUserRepository.findByUsername(user.getUsername()).isPresent();
// if (exists) {
// throw new RuntimeException(String.format("User %s dah ada",
// user.getUsername()));
// // throw new IllegalStateException("username already taken");
// }
// String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
// user.setPassword(encodedPassword);
// return appUserRepository.save(user);
// }
// }
