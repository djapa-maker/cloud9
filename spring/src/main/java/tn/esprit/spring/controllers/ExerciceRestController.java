package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Exercice;
import tn.esprit.spring.services.IExerciceServices;


import java.util.List;

    @Tag(name = "\uD83D\uDC69\u200D\uD83C\uDFEB Exercice Management")
    @RestController
    @RequestMapping("/exercice")
    @RequiredArgsConstructor
    public class ExerciceRestController  {
        private final IExerciceServices exerciceServices;

        @Operation(description = "Add Exercise")
        @PostMapping("/add")
        public Exercice addExercice(@RequestBody Exercice exercice){
            return exerciceServices.addExercice(exercice);
        }

        @Operation(description = "Retrieve all Exercises")
        @GetMapping("/all")
        public List<Exercice> getAllExercices(){
            return exerciceServices.retrieveAllExercice();
        }

        @Operation(description = "Update Exercise")
        @PutMapping("/update")
        public Exercice updateExercice(@RequestBody Exercice exercice){
            return exerciceServices.updateExercice(exercice);
        }

        @Operation(description = "Retrieve Exercise by Id")
        @GetMapping("/get/{id-Exercice}")
        public Exercice getExerciceById(@PathVariable("id-Exercice") Long exerciceId){
            return exerciceServices.retrieveExercice(exerciceId);
        }

        @Operation(description = "Delete Exercise by Id")
        @DeleteMapping("/delete/{id-Exercice}")
        public void deleteExerciceById(@PathVariable("id-Exercice") Long exerciceId){
            exerciceServices.removeExercice(exerciceId);
        }
    }


