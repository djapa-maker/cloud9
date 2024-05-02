package com.example.pokerplanninpi.Repository;

import com.example.pokerplanninpi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
