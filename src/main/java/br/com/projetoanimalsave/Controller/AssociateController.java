package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
