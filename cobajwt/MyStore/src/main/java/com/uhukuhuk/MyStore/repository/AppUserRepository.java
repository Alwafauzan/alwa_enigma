package com.uhukuhuk.MyStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhukuhuk.MyStore.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    public AppUser findByEmail(String email);

}
