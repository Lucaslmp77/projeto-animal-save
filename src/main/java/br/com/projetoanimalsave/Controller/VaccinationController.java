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
}
