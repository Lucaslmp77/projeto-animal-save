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

    @Query("SELECT associate FROM Associate associate INNER JOIN associate.user user WHERE user.pending")
    public List<Associate> findAssociatePending();

    @Query("SELECT caregiver FROM Caregiver caregiver INNER JOIN caregiver.user user WHERE user.pending")
    public List<Caregiver> findCaregiverPending();

    @Query("SELECT provider FROM Provider provider INNER JOIN provider.user user WHERE user.pending")
    public List<Provider> findProviderPending();

    @Query("SELECT associate FROM Associate associate INNER JOIN associate.user user WHERE user.approved")
    public List<Associate> findAssociateApproved();

    @Query("SELECT caregiver FROM Caregiver caregiver INNER JOIN caregiver.user user WHERE user.approved")
    public List<Caregiver> findCaregiverApproved();

    @Query("SELECT provider FROM Provider provider INNER JOIN provider.user user WHERE user.approved")
    public List<Provider> findProviderApproved();

    @Query("SELECT associate FROM Associate associate INNER JOIN associate.user user WHERE user.rejected")
    public List<Associate> findAssociateRejected();

    @Query("SELECT caregiver FROM Caregiver caregiver INNER JOIN caregiver.user user WHERE user.rejected")
    public List<Caregiver> findCaregiverRejected();

    @Query("SELECT provider FROM Provider provider INNER JOIN provider.user user WHERE user.rejected")
    public List<Provider> findProviderRejected();

    @Modifying
    @Query("UPDATE User user SET user.pending = false, user.approved = true," +
            " user.rejected = false WHERE user.id = :id")
    public void updateStatusUserPendingToApproved(@Param("id") Long id);

    @Modifying
    @Query("UPDATE User user SET user.pending = false, user.approved = false," +
            " user.rejected = true WHERE user.id = :id")
    public void updateStatusUserPendingToRejected(@Param("id") Long id);
}