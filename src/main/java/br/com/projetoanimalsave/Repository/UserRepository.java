package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Modifying
    @Query("UPDATE User user SET user.password = :newPassword WHERE user.id = :id")
    public void newPassword(String newPassword, Long id);

    @Query("SELECT associate FROM Associate associate" +
            " INNER JOIN associate.user user WHERE user.id = :id")
    public Optional<Associate> findAssociateByIdUser(Long id);

    @Query("SELECT caregiver FROM Caregiver caregiver" +
            " INNER JOIN caregiver.user user WHERE user.id = :id")
    public Optional<Caregiver> findCaregiverByIdUser(Long id);

}
