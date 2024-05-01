package tn.esprit.spring.repositories;
import java.util.Map;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.Exercice;

public interface IExerciceRepository extends JpaRepository<Exercice, Long>{



}
