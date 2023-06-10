package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Dto.Login;
import br.com.projetoanimalsave.Entity.Admin;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

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

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var admin = (Admin) authenticate.getPrincipal();

        return tokenService.gerarToken(admin);
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

    @PutMapping("/{idAdmin}")
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
}
