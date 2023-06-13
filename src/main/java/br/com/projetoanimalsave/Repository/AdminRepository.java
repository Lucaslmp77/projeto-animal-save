package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT associate FROM Associate associate WHERE associate.pending = true")
    public List<Object> findAssociatePending();

    @Query("SELECT caregiver FROM Caregiver caregiver WHERE caregiver.pending = true")
    public List<Object> findCaregiverPending();

    @Query("SELECT provider FROM Provider provider WHERE provider.pending = true")
    public List<Object> findProviderPending();

    @Modifying
    @Query("UPDATE Associate associate SET associate.pending = false, associate.approved = true," +
            " associate.rejected = false WHERE associate.id = :id")
    public void updateStatusAssociatePendingToApproved(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Caregiver caregiver SET caregiver.pending = false, caregiver.approved = true," +
            " caregiver.rejected = false WHERE caregiver.id = :id")
    public void updateStatusCaregiverPendingToApproved(@Param("id") Long id);
}