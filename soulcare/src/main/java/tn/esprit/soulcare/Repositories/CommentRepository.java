package tn.esprit.soulcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.soulcare.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
