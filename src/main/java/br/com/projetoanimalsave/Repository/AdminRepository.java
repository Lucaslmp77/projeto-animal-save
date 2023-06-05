package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Modifying
    @Query("UPDATE Admin admin SET admin.active = false WHERE admin.id = :id")
    public void disable(@Param("id") Long id);
}
