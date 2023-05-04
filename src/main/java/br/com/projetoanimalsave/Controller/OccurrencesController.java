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
            return ResponseEntity.ok().body("Ocorrências cadastrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<List<Occurrences>> listAll(

    ) {
        return ResponseEntity.ok().body(this.occurrencesService.listAll())
    }

    @GetMapping("/{idOccurrences}")
    public ResponseEntity<Occurrences> findById (
            @PathVariable Long idOccurrences
    ) {
        return ResponseEntity.ok().body(this.occurrencesService.findById(idOccurrences));
    }
}
