package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Post;

public interface PostRepository  extends JpaRepository<Post,Long> {
}
