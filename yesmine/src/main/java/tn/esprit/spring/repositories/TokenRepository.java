package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query("select t from Token t inner join User u on t.user.Id= u.Id where u.Id= :id and (t.expired = false or t.revoked = false)")
  List<Token> findAllValidTokenByUser(Long id);

  Optional<Token> findByToken(String token);
}
