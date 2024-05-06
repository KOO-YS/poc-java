package com.example.plan.repository;

import com.example.plan.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByAccount(String account);

}
