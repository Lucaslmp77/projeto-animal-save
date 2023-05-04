package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/caregiver")
public class CaregiverController {

    @Autowired
    private CaregiverService caregiverService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Caregiver caregiver
    ) {
        try {
            this.caregiverService.save(caregiver);
            return ResponseEntity.ok().body("Cuidadora cadastrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
