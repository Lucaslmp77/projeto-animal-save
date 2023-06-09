package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Entity.Task;
import br.com.projetoanimalsave.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/register")
    public ResponseEntity<?> save(
            @RequestBody Provider provider
    ) {
        try {
            this.providerService.save(provider);
            return ResponseEntity.ok().body("Fornecedor cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Provider>> listAll(

    ) {
        return ResponseEntity.ok().body(this.providerService.listAll());
    }

    @GetMapping("/findTaskActiveByIdProvider/{idProvider}")
    public ResponseEntity<List<Task>> findTaskActiveByIdProvider(
            @PathVariable("idProvider") Long idprovider
    ) {
        return ResponseEntity.ok().body(this.providerService.findTaskActiveByIdProvider(idprovider));
    }

    @GetMapping("/findbyid/{idProvider}")
    public ResponseEntity<Provider> findById(
            @PathVariable("idProvider") Long idprovider
    ) {
        return ResponseEntity.ok().body(this.providerService.findById(idprovider));
    }

    @PutMapping("/update/{idProvider}")
    public ResponseEntity<?> update(
            @PathVariable Long idProvider,
            @RequestBody Provider provider
    ) {
        try {
            this.providerService.update(provider, idProvider);
            return ResponseEntity.ok().body("Fornecedor atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idProvider}")
    public ResponseEntity<?> disable(
            @PathVariable Long idProvider
    ) {
        try {
            this.providerService.disable(idProvider);
            return ResponseEntity.ok().body("Fornecedor deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
