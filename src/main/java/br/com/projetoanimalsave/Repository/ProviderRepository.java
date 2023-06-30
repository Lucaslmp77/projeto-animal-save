package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    @Modifying
    @Query("UPDATE Provider provider SET provider.active = false WHERE provider.id = :id")
    public void disable(@Param("id") Long id);

    @Query("SELECT provider FROM Provider provider where provider.active = true")
    public List<Provider> findByProviderActives();

    @Query("SELECT provider FROM Provider provider where provider.active = false")
    public List<Provider> findByProviderInactives();
}
