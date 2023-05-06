package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Service.AdminService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<?> save(
        @RequestBody Admin admin
    ) {
        try{
            this.adminService.save(admin);
            return ResponseEntity.ok().body("Administrador cadastrado");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Admin>> listAll(

    ) {
        return ResponseEntity.ok().body(this.adminService.listAll());
    }

    @GetMapping("/{idAdmin}")
    public ResponseEntity<Admin> findById (
            @PathVariable Long idAdmin
    ) {
        return ResponseEntity.ok().body(this.adminService.findById(idAdmin));
    }

    @PutMapping("{idAdmin}")
    public ResponseEntity<?> update(
            @PathVariable Long idAdmin,
            @RequestBody Admin admin
    ) {
        try {
            this.adminService.update(admin, idAdmin);
            return ResponseEntity.ok().body("Administrador atualizado");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable{idAdmin}")
    public ResponseEntity<?> disable(
            @PathVariable Long idAdmin
    ) {
        try {
            this.adminService.disable(idAdmin);
            return ResponseEntity.ok().body("Administrador excluido");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
