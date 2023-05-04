package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associate")
public class AssociateController {

    @Autowired
    private AssociateService associateService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Associate associate
    ) {
        try {
            this.associateService.save(associate);
            return ResponseEntity.ok().body("Associado cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Associate>> listAll(

    ) {
        return ResponseEntity.ok().body(this.associateService.listAll());
    }

}
