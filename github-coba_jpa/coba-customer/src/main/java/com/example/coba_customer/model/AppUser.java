// package com.example.coba_customer.model;

// import java.util.Collection;
// import java.util.Collections;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "app_user")

// public class AppUser implements UserDetails {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private String id;
// @Column(length = 100, name = "username", nullable = false, unique = true)
// private String username;
// @Column(length = 200, name = "password", nullable = false)
// private String password;
// @Column(name = "app_user_role", columnDefinition = "smallint")
// @Enumerated(EnumType.STRING)
// private AppUserRole appUserRole;

// @Override
// public Collection<? extends GrantedAuthority> getAuthorities() {
// SimpleGrantedAuthority authority = new
// SimpleGrantedAuthority(appUserRole.name());
// return Collections.singletonList(authority);

// }

// @Override
// public String getPassword() {
// return password;
// }

// @Override
// public String getUsername() {
// return username;
// }

// @Override
// public boolean isAccountNonExpired() {
// return true;
// }

// @Override
// public boolean isAccountNonLocked() {
// return true;
// }

// @Override
// public boolean isCredentialsNonExpired() {
// return true;
// }

// @Override
// public boolean isEnabled() {
// return true;
// }

// public String getId() {
// return id;
// }

// public void setId(String id) {
// this.id = id;
// }

// public void setUsername(String username) {
// this.username = username;
// }

// public void setPassword(String password) {
// this.password = password;
// }

// public AppUserRole getAppUserRole() {
// return appUserRole;
// }

// public void setAppUserRole(AppUserRole appUserRole) {
// this.appUserRole = appUserRole;
// }

// }