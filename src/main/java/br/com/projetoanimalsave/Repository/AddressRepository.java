package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Modifying
    @Query("update Address address set address.active = false where address.id = :idAddress")
    public void disable(@Param("idAddress") Long id);
}
