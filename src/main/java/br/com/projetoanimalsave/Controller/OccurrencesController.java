package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Occurrences;
import br.com.projetoanimalsave.Service.OccurrencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/occurrences")
public class OccurrencesController {

    @Autowired
    private OccurrencesService occurrencesService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Occurrences occurrences
    ) {
        try {
            this.occurrencesService.save(occurrences);
            return ResponseEntity.ok().body("Ocorrência cadastrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Occurrences>> listAll(

    ) {
        return ResponseEntity.ok().body(this.occurrencesService.listAll());
    }

    @GetMapping("/{idOccurrences}")
    public ResponseEntity<Occurrences> findById (
            @PathVariable Long idOccurrences
    ) {
        return ResponseEntity.ok().body(this.occurrencesService.findById(idOccurrences));
    }

    @PutMapping("/{idOccurrences}")
    public ResponseEntity<?> update(
            @PathVariable Long idOccurrences,
            @RequestBody Occurrences occurrences
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
            return ResponseEntity.ok().body("Ocorrência excluida!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
