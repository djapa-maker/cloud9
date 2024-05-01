package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.*;

import javafx.geometry.Pos;
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
public class Exercice  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long exerciseId;
    String title;
    String description;

    @Enumerated(EnumType.STRING)
    DifficultyLevels difficultyLevel;

    int duration;

    @Enumerated(EnumType.STRING)
    StressLevelReductions stressLevelReduction;

    @ManyToOne
    Category categorie;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="exercice")
    private Set<ExerciseMedia> exercicemedias;
}
