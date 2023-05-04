package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Animal;
import br.com.projetoanimalsave.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Animal animal
    ) {
        try {
            this.animalService.save(animal);
            return ResponseEntity.ok().body("Animal cadastrado");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
