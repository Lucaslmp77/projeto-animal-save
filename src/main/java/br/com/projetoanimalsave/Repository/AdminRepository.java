package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT associate FROM Associate associate WHERE associate.aprove = :aprove")
    public List<Object> findAssociatePending(Aprove aprove);

    @Query("SELECT caregiver FROM Caregiver caregiver WHERE caregiver.aprove = :aprove")
    public List<Object> findCaregiverPending(Aprove aprove);

    @Query("SELECT provider FROM Provider provider WHERE provider.aprove = :aprove")
    public List<Object> findProviderPending(Aprove aprove);
}