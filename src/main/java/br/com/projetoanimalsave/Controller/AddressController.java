package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Address;
import br.com.projetoanimalsave.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Address>> listAll(

    ) {
        return ResponseEntity.ok().body(this.addressService.listAll());
    }

    @GetMapping("/{idAddress}")
    public ResponseEntity<Address> findById (
            @PathVariable Long idAddress
    ) {
        return ResponseEntity.ok().body(this.addressService.findById(idAddress));
    }

    @PutMapping("/{idAddress}")
    public ResponseEntity<?> update(
            @PathVariable Long idAddress,
            @RequestBody Address address
    ) {
        try {
            this.addressService.update(address, idAddress);
            return ResponseEntity.ok().body("Endereço atualizado!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
