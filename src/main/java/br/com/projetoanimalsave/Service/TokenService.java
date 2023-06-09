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
                .withIssuer("Administrador")
                .withSubject(admin.getUsername())
                .withClaim("id", admin.getId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(1440)
                        .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256("deregues"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("deregues"))
                .withIssuer("Administrador")
                .build().verify(token).getSubject();

    }
}
