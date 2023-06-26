package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Dto.Login;
import br.com.projetoanimalsave.Dto.NewPassword;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Service.TokenService;
import br.com.projetoanimalsave.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var usuario = (User) authenticate.getPrincipal();

        return tokenService.gerarToken(usuario);
    }

    @PutMapping("/new/password/{idUser}")
    public ResponseEntity<?> newPassword(
            @PathVariable Long idUser,
            @RequestBody NewPassword newPassword
            ) {
        try {
            this.userService.newPassword(newPassword.getNewPassword(), idUser);
            return ResponseEntity.ok().body("Senha atualizada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findAssociateByIdUser/{idUser}")
    public ResponseEntity<?> findAssociateByIdUser (
            @PathVariable Long idUser
    ) {
        return ResponseEntity.ok().body(this.userService.findAssociateByIdUser(idUser));
    }
}
