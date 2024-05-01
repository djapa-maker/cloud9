    package tn.esprit.spring.entities;

    import java.io.Serializable;



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
    public class ExerciseMedia  implements Serializable  {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        Long mediaId;

        @ManyToOne
        Exercice exercice;

        String mediaUrl;
    }
