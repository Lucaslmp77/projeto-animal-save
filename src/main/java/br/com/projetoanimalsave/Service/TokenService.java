package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String gerarToken(Admin admin) {
        return JWT.create()
                .withIssuer("Produtos")
                .withSubject(admin.getUsername())
                .withClaim("id", admin.getId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(30)
                        .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256("secreta"));
    }
}
