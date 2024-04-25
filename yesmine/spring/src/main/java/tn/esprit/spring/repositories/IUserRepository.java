package tn.esprit.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.User;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {
//find user by email
@Query("SELECT u FROM User u WHERE u.email = ?1")
Optional<User> findByEmail(String email);
}
