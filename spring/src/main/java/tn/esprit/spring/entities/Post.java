package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String content;
    private LocalDateTime datePosted;
    private int likes;
    private int dislikes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="post")
    private Set<Comment> comments;

    @ManyToMany(mappedBy="posts", cascade = CascadeType.ALL)
    private Set<Exercice> exercices;

}
