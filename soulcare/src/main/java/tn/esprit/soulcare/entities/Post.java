package tn.esprit.soulcare.entities;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String content;
    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    private Blob image;
    private LocalDateTime datePosted;
    private int likes;
    private int dislikes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="post")
    private Set<Comment> comments;
}
