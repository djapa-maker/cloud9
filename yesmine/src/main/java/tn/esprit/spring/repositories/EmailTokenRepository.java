package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.EmailToken;

import java.util.List;
import java.util.Optional;

public interface EmailTokenRepository extends JpaRepository<EmailToken, Integer> {

    Optional<EmailToken> findByEmailtoken(String EmailToken);
}
