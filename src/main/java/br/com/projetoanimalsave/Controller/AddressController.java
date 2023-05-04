package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Address;
import br.com.projetoanimalsave.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Address address
    ) {
        try {
            this.addressService.save(address);
            return ResponseEntity.ok().body("Endereço cadastrado!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
