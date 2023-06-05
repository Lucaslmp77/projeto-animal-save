package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {
    @Modifying
    @Query("UPDATE Associate associate SET associate.active = false WHERE associate.id = :id")
    public void disable(@Param("id") Long id);
}
