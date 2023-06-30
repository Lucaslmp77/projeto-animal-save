package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
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

    @GetMapping("/listall")
    public ResponseEntity<List<Admin>> listAll(

    ) {
        return ResponseEntity.ok().body(this.adminService.listAll());
    }

    @GetMapping("/findbyid/{idAdmin}")
    public ResponseEntity<Admin> findById (
            @PathVariable Long idAdmin
    ) {
        return ResponseEntity.ok().body(this.adminService.findById(idAdmin));
    }

    @GetMapping("/approves/pending")
    public ResponseEntity<?> findAllPending(

    ) {
        return ResponseEntity.ok().body(this.adminService.findAllPending());
    }

    @GetMapping("/approves/approved")
    public ResponseEntity<?> findAllApproved(

    ) {
        return ResponseEntity.ok().body(this.adminService.findAllApproved());
    }

    @GetMapping("/approves/rejected")
    public ResponseEntity<?> findAllRejected(

    ) {
        return ResponseEntity.ok().body(this.adminService.findAllRejected());
    }

    @PutMapping("/approved/user/{idUser}")
    public ResponseEntity<?> updateStatusUserPendingToApproved(
            @PathVariable Long idUser
    ) {
        try {
            this.adminService.updateStatusUserPendingToApproved(idUser);
            return ResponseEntity.ok().body("Usuário aprovado!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/rejected/user/{idUser}")
    public ResponseEntity<?> updateStatusUserPendingToRejected(
            @PathVariable Long idUser
    ) {
        try {
            this.adminService.updateStatusUserPendingToRejected(idUser);
            return ResponseEntity.ok().body("Usuário reprovado!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
