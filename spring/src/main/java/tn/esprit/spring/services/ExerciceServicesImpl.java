package tn.esprit.spring.services;

import tn.esprit.spring.entities.Exercice;
import tn.esprit.spring.repositories.IExerciceRepository;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExerciceServicesImpl implements IExerciceServices {

    private IExerciceRepository exerciceRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Exercice addExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    @Override
    public List<Exercice> retrieveAllExercice() {
        return exerciceRepository.findAll();
    }

    @Override
    public Exercice updateExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    @Override
    public Exercice retrieveExercice(Long exerciseId) {
        return exerciceRepository.findById(exerciseId).orElse(null);
    }

    @Override
    public void removeExercice(Long exerciseId) {
        exerciceRepository.deleteById(exerciseId);
    }


}
