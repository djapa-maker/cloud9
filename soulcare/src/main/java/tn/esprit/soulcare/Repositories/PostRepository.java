package tn.esprit.soulcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.soulcare.entities.Post;

public interface PostRepository  extends JpaRepository<Post,Long> {
}
