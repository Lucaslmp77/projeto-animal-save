package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Address;
import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.AddressRepository;
import br.com.projetoanimalsave.Repository.CaregiverRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaregiverServiceTest {

    @Mock
    private CaregiverRepository caregiverRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private GenerateCodeService generateCodeService;

    @InjectMocks
    private CaregiverService caregiverService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCaregiverTest() {
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

        Caregiver caregiver = new Caregiver();
        caregiver.setFirstName("Lucas");
        caregiver.setLastName("Mendes");
        caregiver.setContact("123456789");
        caregiver.setCpf("637.031.060-34");
        caregiver.setPhysicalSpace("400 metros");
        caregiver.setSpending("2.000,00");
        caregiver.setCapacityAnimals(32.0);

        caregiver.setUser(user);
        caregiver.setAddress(address);

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        when(caregiverRepository.save(any(Caregiver.class))).thenReturn(caregiver);

        Caregiver savedCaregiver = caregiverService.save(caregiver);

        assertNotNull(savedCaregiver);
        assertEquals("Lucas", savedCaregiver.getFirstName());
        assertEquals("Mendes", savedCaregiver.getLastName());
        assertEquals(address.getId(), savedCaregiver.getAddress().getId());
        assertEquals(user.getId(), savedCaregiver.getId());
        assertEquals(user.getLogin(), savedCaregiver.getUser().getLogin());

        verify(userRepository, times(1)).save(any(User.class));
        verify(addressRepository, times(1)).save(any(Address.class));
        verify(caregiverRepository, times(1)).save(any(Caregiver.class));
    }

    @Test
    void listAllCaregiversTest() {
        List<Caregiver> caregivers = new ArrayList<>();
        caregivers.add(new Caregiver());
        caregivers.add(new Caregiver());

        when(caregiverRepository.findAll()).thenReturn(caregivers);

        List<Caregiver> result = caregiverService.listAll();

        assertNotNull(result);
        assertEquals(2, result.size());

        verify(caregiverRepository, times(1)).findAll();
    }

    @Test
    void findByCaregiverActivesTest() {
        List<Caregiver> caregivers = new ArrayList<>();
        caregivers.add(new Caregiver());

        when(caregiverRepository.findByCaregiverActives()).thenReturn(caregivers);

        List<Caregiver> result = caregiverService.findByCaregiverActives();

        assertNotNull(result);
        assertEquals(1, result.size());

        verify(caregiverRepository, times(1)).findByCaregiverActives();
    }

    @Test
    void findByIdExistingTest() {
        Long caregiverId = 1L;
        Caregiver caregiver = new Caregiver();
        caregiver.setId(caregiverId);

        when(caregiverRepository.findById(caregiverId)).thenReturn(Optional.of(caregiver));

        Caregiver result = caregiverService.findById(caregiverId);

        assertNotNull(result);
        assertEquals(caregiverId, result.getId());

        verify(caregiverRepository, times(1)).findById(caregiverId);
    }

    @Test
    void findByIdNonExistingTest() {
        Long caregiverId = 1L;

        when(caregiverRepository.findById(caregiverId)).thenReturn(Optional.empty());

        Caregiver result = caregiverService.findById(caregiverId);

        assertNotNull(result);
        assertNull(result.getId());

        verify(caregiverRepository, times(1)).findById(caregiverId);
    }

    @Test
    void updateMatchingIdTest() {
        Long caregiverId = 1L;
        Caregiver caregiver = new Caregiver();
        caregiver.setId(caregiverId);

        Address address = new Address();
        address.setCep("00000000");
        address.setNeighborhood("Bairro da protetora");
        address.setRoad("Rua da protetora");
        address.setHouseNumber(99);

        caregiver.setAddress(address);

        when(caregiverRepository.save(any(Caregiver.class))).thenReturn(caregiver);

        caregiverService.update(caregiverId, caregiver);

        verify(caregiverRepository, times(1)).save(caregiver);
    }

    @Test
    void updateNonMatchingIdTest() {
        Long caregiverId = 1L;
        Long nonMatchingId = 2L;
        Caregiver caregiver = new Caregiver();
        caregiver.setId(caregiverId);

        assertThrows(RuntimeException.class, () -> caregiverService.update(nonMatchingId, caregiver));

        verify(caregiverRepository, never()).save(any(Caregiver.class));
    }

    @Test
    void disableExistingCaregiverTest() {
        Long caregiverId = 1L;
        Caregiver caregiver = new Caregiver();
        caregiver.setId(caregiverId);
        Optional<Caregiver> optionalCaregiver = Optional.of(caregiver);

        when(caregiverRepository.findById(caregiverId)).thenReturn(optionalCaregiver);

        caregiverService.disable(caregiverId);

        verify(caregiverRepository, times(1)).disable(caregiverId);
    }

    @Test
    void disableNonExistingCaregiverTest() {
        Long caregiverId = 1L;

        when(caregiverRepository.findById(caregiverId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> caregiverService.disable(caregiverId));

        verify(caregiverRepository, never()).disable(anyLong());
    }
}
