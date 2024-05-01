package tn.esprit.spring.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class User2 {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long Id;
    String firstname;
    String lastname;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
}
