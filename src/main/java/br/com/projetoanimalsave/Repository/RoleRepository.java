package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Modifying
    @Query(value = "insert into tb_admin_role (admin_id, role_id) VALUES (:idAdm, :idRole)", nativeQuery = true)
    public void addRelationAdmWithRole(Long idAdm, Long idRole);

    @Modifying
    @Query(value = "insert into tb_caregiver_role (caregiver_id, role_id) VALUES (:idCgv, :idRole)", nativeQuery = true)
    public void addRelationCgvWithRole(Long idCgv, Long idRole);
}
