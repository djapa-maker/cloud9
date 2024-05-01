package tn.esprit.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Category;
public interface ICategoryRespository extends JpaRepository<Category, Long> {
}
