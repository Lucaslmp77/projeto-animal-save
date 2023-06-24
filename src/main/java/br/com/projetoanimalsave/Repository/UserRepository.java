package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Modifying
    @Query("UPDATE User user SET user.password = :password WHERE user.id = :id")
    public void newPassword(String password, Long id);
}
