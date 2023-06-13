package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Config.JwtConstants;
import br.com.projetoanimalsave.Entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String gerarToken(User user) {
        return JWT.create()
                .withIssuer("Administrador")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(1440)
                        .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256(JwtConstants.SECRET));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(JwtConstants.SECRET))
                .withIssuer("Administrador")
                .build().verify(token).getSubject();

    }
}
