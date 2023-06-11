package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Dto.Login;
import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Service.AdminService;
import br.com.projetoanimalsave.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
}
