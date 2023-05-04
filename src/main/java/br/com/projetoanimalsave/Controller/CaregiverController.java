package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Caregiver>> listAll(

    ) {
        return ResponseEntity.ok().body(this.caregiverService.listAll());
    }

    @GetMapping("/{idCaregiver}")
    public ResponseEntity<Caregiver> findById (
            @PathVariable Long idCaregiver
    ) {
        return ResponseEntity.ok().body(this.caregiverService.findById(idCaregiver));
    }

    @PutMapping("/{idCaregiver}")
    public ResponseEntity<?> update(
            @PathVariable Long idCaregiver,
            @RequestBody Caregiver caregiver
    ) {
        try {
            this.caregiverService.update(caregiver, idCaregiver);
            return ResponseEntity.ok().body("Cuidadora atualizada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idCaregiver}")
    public ResponseEntity<?> delete(
            @PathVariable Long idCaregiver,
            @RequestBody Caregiver caregiver
    ) {
        try {
            this.caregiverService.update(caregiver, idCaregiver);
            return ResponseEntity.ok().body("Cuidadora atualizada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
