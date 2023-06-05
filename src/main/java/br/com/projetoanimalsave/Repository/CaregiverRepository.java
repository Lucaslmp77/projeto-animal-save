package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {
    @Query("SELECT caregiver FROM Caregiver caregiver where caregiver.active = true")
    public List<Caregiver> findByCaregiverActives();

    @Modifying
    @Query("update Caregiver caregiver set caregiver.active = false where caregiver.id = :idCaregiver")
    public void disable(@Param("idCaregiver")Long id);
}
