package tn.esprit.spring.services;

import tn.esprit.spring.entities.ExerciseMedia;
import tn.esprit.spring.repositories.IExerciseMediaRepository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExerciseMediaServicesImpl implements IExerciseMediaServices {
    private final IExerciseMediaRepository exerciseMediaRepository;

    @Override
    public ExerciseMedia addExerciseMedia(ExerciseMedia exerciseMedia) {
        return exerciseMediaRepository.save(exerciseMedia);
    }

    @Override
    public List<ExerciseMedia> retrieveAllExerciseMedia() {
        return exerciseMediaRepository.findAll();
    }

    @Override
    public ExerciseMedia updateExerciseMedia(ExerciseMedia exerciseMedia) {
        return exerciseMediaRepository.save(exerciseMedia);
    }

    @Override
    public ExerciseMedia retrieveExerciseMedia(Long mediaId) {
        return exerciseMediaRepository.findById(mediaId).orElse(null);
    }

    @Override
    public void removeExerciseMedia(Long mediaId) {
        exerciseMediaRepository.deleteById(mediaId);
    }
}
