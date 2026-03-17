package com.example.loanEngine.repository;

import com.example.loanEngine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
