package tn.esprit.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.User2;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User2, Long> {
//find user by email
@Query("SELECT u FROM User u WHERE u.email = ?1")
Optional<User2> findByEmail(String email);
}
