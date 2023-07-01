package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Address;
import br.com.projetoanimalsave.Repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressServiceTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void saveAddress() {
        Address address = new Address();
        address.setCep("00000000");
        address.setNeighborhood("bairro da alameda final");
        address.setRoad("rua caminhao do isekai");
        address.setHouseNumber(32);

        Address savedAddress = addressRepository.save(address);

        assertNotNull(savedAddress.getId());
        assertEquals("00000000", savedAddress.getCep());
        assertEquals("bairro da alameda final", savedAddress.getNeighborhood());
        assertEquals("rua caminhao do isekai", savedAddress.getRoad());
        assertEquals(32, savedAddress.getHouseNumber());
    }

    @Test
    public void listAllAddresses() {
        Address address1 = new Address();
        address1.setCep("11111111");
        address1.setNeighborhood("bairro 1");
        address1.setRoad("rua 1");
        address1.setHouseNumber(1);

        Address address2 = new Address();
        address2.setCep("22222222");
        address2.setNeighborhood("bairro 2");
        address2.setRoad("rua 2");
        address2.setHouseNumber(2);

        addressRepository.save(address1);
        addressRepository.save(address2);

        List<Address> addresses = addressRepository.findAll();

        assertEquals(2, addresses.size());
    }

    @Test
    public void findAddressById() {
        Address address = new Address();
        address.setCep("33333333");
        address.setNeighborhood("bairro 3");
        address.setRoad("rua 3");
        address.setHouseNumber(3);

        Address savedAddress = addressRepository.save(address);

        Address foundAddress = addressRepository.findById(savedAddress.getId()).orElse(null);

        assertNotNull(foundAddress);
        assertEquals("33333333", foundAddress.getCep());
        assertEquals("bairro 3", foundAddress.getNeighborhood());
        assertEquals("rua 3", foundAddress.getRoad());
        assertEquals(3, foundAddress.getHouseNumber());
    }

    @Test
    public void updateAddress() {
        Address address = new Address();
        address.setCep("44444444");
        address.setNeighborhood("bairro 4");
        address.setRoad("rua 4");
        address.setHouseNumber(4);

        Address savedAddress = addressRepository.save(address);

        savedAddress.setCep("55555555");
        savedAddress.setNeighborhood("bairro 5");
        savedAddress.setRoad("rua 5");
        savedAddress.setHouseNumber(5);

        addressRepository.save(savedAddress);

        Address updatedAddress = addressRepository.findById(savedAddress.getId()).orElse(null);

        assertNotNull(updatedAddress);
        assertEquals("55555555", updatedAddress.getCep());
        assertEquals("bairro 5", updatedAddress.getNeighborhood());
        assertEquals("rua 5", updatedAddress.getRoad());
        assertEquals(5, updatedAddress.getHouseNumber());
    }
}
