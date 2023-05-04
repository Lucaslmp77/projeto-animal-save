package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Vaccination;
import br.com.projetoanimalsave.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.ok().body("Vacinação cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
