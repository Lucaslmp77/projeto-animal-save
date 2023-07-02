package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Animal;
import br.com.projetoanimalsave.Entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {

    @Query("SELECT caregiver FROM Caregiver caregiver where caregiver.active = true")
    public List<Caregiver> findByCaregiverActives();

    @Modifying
    @Query("update Caregiver caregiver set caregiver.active = false where caregiver.id = :idCaregiver")
    public void disable(@Param("idCaregiver")Long id);

    @Query("SELECT animal FROM Animal animal INNER JOIN animal.caregiver caregiver WHERE caregiver.id = :id " +
            "AND animal.active = true")
    public List<Animal> findAnimalActiveByIdCaregiver(Long id);
}
