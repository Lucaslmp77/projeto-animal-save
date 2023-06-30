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

    @PostMapping("/register")
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

    @GetMapping("/listall")
    public ResponseEntity<List<Associate>> listAll(

    ) {
        return ResponseEntity.ok().body(this.associateService.listAll());
    }

    @GetMapping("/actives")
    public ResponseEntity<List<Associate>> findByAssociateActives(

    ) {
        return ResponseEntity.ok().body(this.associateService.findByAssociateActives());
    }

    @GetMapping("/inactives")
    public ResponseEntity<List<Associate>> findByAssociateInactives(

    ) {
        return ResponseEntity.ok().body(this.associateService.findByAssociateInactives());
    }

    @GetMapping("/findbyid/{idAssociate}")
    public ResponseEntity<Associate> findById(
            @PathVariable("idAssociate") Long idAssociate
    ) {
        return ResponseEntity.ok().body(this.associateService.findById(idAssociate));
    }

    @PutMapping("/update/{idAssociate}")
    public ResponseEntity<?> update(
            @PathVariable Long idAssociate,
            @RequestBody Associate associate
    ) {
        try {
            this.associateService.update(associate, idAssociate);
            return ResponseEntity.ok().body("Associado atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idAssociate}")
    public ResponseEntity<?> disable(
            @PathVariable Long idAssociate
    ) {
        try {
            this.associateService.disable(idAssociate);
            return ResponseEntity.ok().body("Associado deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
