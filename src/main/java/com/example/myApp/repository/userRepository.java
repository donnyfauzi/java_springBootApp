package com.example.myApp.repository;

import com.example.myApp.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email); // Untuk mencari user berdasarkan email
}
