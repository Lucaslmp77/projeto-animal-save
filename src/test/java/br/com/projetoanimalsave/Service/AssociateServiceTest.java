package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.*;
import br.com.projetoanimalsave.Repository.AddressRepository;
import br.com.projetoanimalsave.Repository.AssociateRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AssociateServiceTest {

    @Mock
    private AssociateRepository associateRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private GenerateCodeService generateCodeService;

    @InjectMocks
    private AssociateService associateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveAssociate() {
        User user = new User();
        user.setLogin("lucas@example.com");
        user.setPassword("luska");
        user.setApproved(false);
        user.setPending(true);
        user.setRejected(false);

        Role caregiverRole = new Role();
        caregiverRole.setAuthority("ROLE_CAREGIVER");
        user.getRoles().add(caregiverRole);

        Address address = new Address();
        address.setCep("00000000");
        address.setNeighborhood("bairro da alameda final");
        address.setRoad("rua caminhao do isekai");
        address.setHouseNumber(32);

        Associate associate = new Associate();
        associate.setFirstName("John");
        associate.setLastName("Doe");
        associate.setContact("123456789");
        associate.setUser(user);
        associate.setAddress(address);

        when(userRepository.save(any(User.class))).thenReturn(new User());
        when(addressRepository.save(any(Address.class))).thenReturn(new Address());
        when(associateRepository.save(any(Associate.class))).thenReturn(associate);

        Associate savedAssociate = associateService.save(associate);

        assertNotNull(savedAssociate);
        assertNotNull(savedAssociate.getUser());
        assertNotNull(savedAssociate.getAddress());

        verify(userRepository, times(1)).save(any(User.class));
        verify(addressRepository, times(1)).save(any(Address.class));
        verify(associateRepository, times(1)).save(any(Associate.class));
    }

    @Test
    void testListAllAssociates() {
        when(associateRepository.findAll()).thenReturn(List.of(new Associate(), new Associate()));

        List<Associate> associates = associateService.listAll();

        assertEquals(2, associates.size());
        verify(associateRepository, times(1)).findAll();
    }

    @Test
    void testFindAssociateById() {
        Long associateId = 1L;
        Associate associate = new Associate();
        associate.setId(associateId);

        when(associateRepository.findById(associateId)).thenReturn(Optional.of(associate));

        Associate foundAssociate = associateService.findById(associateId);

        assertNotNull(foundAssociate);
        assertEquals(associateId, foundAssociate.getId());

        verify(associateRepository, times(1)).findById(associateId);
    }

    @Test
    void testFindAssociateByIdNotFound() {
        Long associateId = 1L;

        when(associateRepository.findById(associateId)).thenReturn(Optional.empty());

        Associate foundAssociate = associateService.findById(associateId);

        assertNotNull(foundAssociate);
        assertNull(foundAssociate.getId());

        verify(associateRepository, times(1)).findById(associateId);
    }


    @Test
    void testUpdateAssociate() {
        User user = new User();
        user.setLogin("lucas@example.com");
        user.setPassword("luska");
        user.setApproved(false);
        user.setPending(true);
        user.setRejected(false);

        Role caregiverRole = new Role();
        caregiverRole.setAuthority("ROLE_CAREGIVER");
        user.getRoles().add(caregiverRole);

        Address address = new Address();
        address.setCep("00000000");
        address.setNeighborhood("bairro da alameda final");
        address.setRoad("rua caminhao do isekai");
        address.setHouseNumber(32);

        Long associateId = 1L;
        Associate associate = new Associate();
        associate.setId(associateId);
        associate.setFirstName("John");
        associate.setLastName("Doe");
        associate.setContact("123456789");
        associate.setUser(user);
        associate.setAddress(address);

        when(associateRepository.save(any(Associate.class))).thenReturn(associate);

        associateService.update(associate, associateId);

        verify(associateRepository, times(1)).save(associate);
    }

}
