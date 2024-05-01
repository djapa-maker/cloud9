package tn.esprit.spring.services;

import tn.esprit.spring.entities.Exercice;

import java.util.List;
import java.util.Map;

public interface IExerciceServices {
    Exercice addExercice(Exercice exercice);

    List<Exercice> retrieveAllExercice();

    Exercice updateExercice(Exercice Exercice);

    Exercice retrieveExercice(Long IdExercice);
    void removeExercice (Long IdExercice);

}
