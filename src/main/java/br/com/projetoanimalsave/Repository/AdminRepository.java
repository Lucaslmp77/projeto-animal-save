package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(nativeQuery = true, value = """
			SELECT "projeto-animal-save".tb_administradores.email AS username, tb_administradores.senha, tb_role.id 
			AS roleId, tb_role.authority FROM "projeto-animal-save".tb_administradores 
			INNER JOIN tb_admin_role ON tb_administradores.id = tb_admin_role.admin_id
   			INNER JOIN "projeto-animal-save".tb_role ON tb_role.id = tb_admin_role.role_id
   			WHERE tb_administradores.email = :email
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}