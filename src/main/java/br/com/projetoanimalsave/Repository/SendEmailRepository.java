package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.SendEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendEmailRepository extends JpaRepository<SendEmail, Long> {
}
