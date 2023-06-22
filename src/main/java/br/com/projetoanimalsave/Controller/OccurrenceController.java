package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Occurrence;
import br.com.projetoanimalsave.Service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/occurrence")
public class OccurrenceController {

    @Autowired
    private OccurrenceService occurrenceService;

    @PostMapping("/register")
    public ResponseEntity<?> save(
            @RequestBody Occurrence occurrence
    ) {
        try {
            this.occurrenceService.save(occurrence);
            return ResponseEntity.ok().body("Ocorrência cadastrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Occurrence>> listAll(

    ) {
        return ResponseEntity.ok().body(this.occurrenceService.listAll());
    }

    @GetMapping("/findbyid/{idOccurrence}")
    public ResponseEntity<Occurrence> findById (
            @PathVariable Long idOccurrence
    ) {
        return ResponseEntity.ok().body(this.occurrenceService.findById(idOccurrence));
    }

    @PutMapping("/update/{idOccurrence}")
    public ResponseEntity<?> update(
            @PathVariable Long idOccurrence,
            @RequestBody Occurrence occurrence
    ) {
        try {
            this.occurrenceService.update(occurrence, idOccurrence);
            return ResponseEntity.ok().body("Ocorrência atualizada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idOccurrence}")
    public ResponseEntity<?> disable(
            @PathVariable Long idOccurrence
    ) {
        try {
            this.occurrenceService.disable(idOccurrence);
            return ResponseEntity.ok().body("Ocorrência desativada!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/actives")
    public ResponseEntity<?> findByOccurrenceActives() {
        return ResponseEntity.ok().body(this.occurrenceService.findByOccurrenceActives());
    }

    @GetMapping("/inactives")
    public ResponseEntity<?> findByOccurrenceInactives() {
        return ResponseEntity.ok().body(this.occurrenceService.findByOccurrenceInactives());
    }
}
