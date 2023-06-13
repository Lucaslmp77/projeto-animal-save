package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Occurrence;
import br.com.projetoanimalsave.Service.OccurrencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/occurrence")
public class OccurrencesController {

    @Autowired
    private OccurrencesService occurrencesService;

    @PostMapping("/register")
    public ResponseEntity<?> save(
            @RequestBody Occurrence occurrences
    ) {
        try {
            this.occurrencesService.save(occurrences);
            return ResponseEntity.ok().body("Ocorrência cadastrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Occurrence>> listAll(

    ) {
        return ResponseEntity.ok().body(this.occurrencesService.listAll());
    }

    @GetMapping("/findbyid/{idOccurrences}")
    public ResponseEntity<Occurrence> findById (
            @PathVariable Long idOccurrences
    ) {
        return ResponseEntity.ok().body(this.occurrencesService.findById(idOccurrences));
    }

    @PutMapping("/update/{idOccurrences}")
    public ResponseEntity<?> update(
            @PathVariable Long idOccurrences,
            @RequestBody Occurrence occurrences
    ) {
        try {
            this.occurrencesService.update(occurrences, idOccurrences);
            return ResponseEntity.ok().body("Ocorrência atualizada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idOccurrences}")
    public ResponseEntity<?> disable(
            @PathVariable Long idOccurrences
    ) {
        try {
            this.occurrencesService.disable(idOccurrences);
            return ResponseEntity.ok().body("Ocorrência desativada!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/actives")
    public ResponseEntity<?> findByOccurrenceActives() {
        return ResponseEntity.ok().body(this.occurrencesService.findByOccurrenceActives());
    }

    @PutMapping("/respond/{idCaregiver}")
    public ResponseEntity<?> respondToOccurrence(
            @PathVariable Long idCaregiver
    ) {
        try {
            this.occurrencesService.respondToOccurrence(idCaregiver);
            return ResponseEntity.ok().body("Ocorrência atendida!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
