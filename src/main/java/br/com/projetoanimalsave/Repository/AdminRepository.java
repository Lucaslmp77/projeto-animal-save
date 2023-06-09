package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByLogin(String login);
}