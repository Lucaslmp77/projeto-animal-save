package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Vaccination;
import br.com.projetoanimalsave.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Vaccination vaccination
    ) {
        try {
            this.vaccinationService.save(vaccination);
            return ResponseEntity.ok().body("Vacinação cadastrada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Vaccination>> listAll(

    ) {
        return ResponseEntity.ok().body(this.vaccinationService.listAll());
    }

    @GetMapping("/{idVaccination}")
    public ResponseEntity<Vaccination> findById(
            @PathVariable("idProvider") Long idVaccination
    ) {
        return ResponseEntity.ok().body(this.vaccinationService.findById(idVaccination));
    }

    @PutMapping("/{idVaccination}")
    public ResponseEntity<?> update(
            @PathVariable Long idVaccination,
            @RequestBody Vaccination vaccination
    ) {
        try {
            this.vaccinationService.update(vaccination, idVaccination);
            return ResponseEntity.ok().body("Vacinação atualizada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idTask}")
    public ResponseEntity<?> disable(
            @PathVariable Long idVaccination
    ) {
        try {
            this.vaccinationService.disable(idVaccination);
            return ResponseEntity.ok().body("Vacinações excluidas!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
