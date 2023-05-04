package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
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
}
