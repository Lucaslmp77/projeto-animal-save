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

    @PostMapping("/register")
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

    @GetMapping("/listall")
    public ResponseEntity<List<Animal>> listAll(

    ) {
        return ResponseEntity.ok().body(this.animalService.listAll());
    }

    @GetMapping("/findbyid{idAnimal}")
    public ResponseEntity<Animal> findById (
            @PathVariable Long idAnimal
    ) {
        return ResponseEntity.ok().body(this.animalService.findById(idAnimal));
    }

    @PutMapping("/update/{idAnimal}")
    public ResponseEntity<?> update(
            @PathVariable Long idAnimal,
            @RequestBody Animal animal
    ) {
        try {
            this.animalService.update(animal, idAnimal);
            return ResponseEntity.ok().body("Animal atualizado!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idAnimal}")
    public ResponseEntity<?> disable(
            @PathVariable Long idAnimal
    ) {
        try {
            this.animalService.disable(idAnimal);
            return ResponseEntity.ok().body("Animal Excluido!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
