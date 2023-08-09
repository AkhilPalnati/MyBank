package com.banking.java.repository;

import com.banking.java.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    User findByAccountNumber(String accountNumber);
}
