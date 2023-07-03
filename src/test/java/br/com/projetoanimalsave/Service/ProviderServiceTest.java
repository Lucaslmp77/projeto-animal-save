package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Address;
import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.AddressRepository;
import br.com.projetoanimalsave.Repository.ProviderRepository;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProviderServiceTest {

    @Mock
    private ProviderRepository providerRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private GenerateCodeService generateCodeService;

    @InjectMocks
    private ProviderService providerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProvider() {
        User user = new User();
        user.setLogin("lucas@example.com");
        user.setPassword("luska");
        user.setApproved(false);
        user.setPending(true);
        user.setRejected(false);

        Role providerRole = new Role();
        providerRole.setAuthority("ROLE_PROVIDER");
        user.getRoles().add(providerRole);

        Address address = new Address();
        address.setCep("00000000");
        address.setNeighborhood("bairro da alameda final");
        address.setRoad("rua caminhao do isekai");
        address.setHouseNumber(32);

        Provider provider = new Provider();
        provider.setUser(user);
        provider.setAddress(address);

        when(userRepository.save(any(User.class))).thenReturn(new User());
        when(addressRepository.save(any(Address.class))).thenReturn(new Address());
        when(providerRepository.save(provider)).thenReturn(provider);

        Provider savedProvider = providerService.save(provider);

        assertNotNull(savedProvider);
        assertEquals(user.getId(), savedProvider.getUser().getId());
        assertEquals(user.getLogin(), savedProvider.getUser().getLogin());
        assertEquals(address.getId(), savedProvider.getAddress().getId());

        verify(userRepository, times(1)).save(any(User.class));
        verify(addressRepository, times(1)).save(any(Address.class));
        verify(providerRepository, times(1)).save(provider);
    }

    @Test
    void testListAllProviders() {
        List<Provider> providerList = Collections.singletonList(new Provider());

        when(providerRepository.findAll()).thenReturn(providerList);

        List<Provider> result = providerService.listAll();

        assertEquals(1, result.size());
        assertSame(providerList, result);

        verify(providerRepository, times(1)).findAll();
    }

    @Test
    void testFindProviderById() {
        Long providerId = 1L;
        Provider provider = new Provider();
        provider.setId(providerId);

        when(providerRepository.findById(providerId)).thenReturn(Optional.of(provider));

        Provider result = providerService.findById(providerId);

        assertNotNull(result);
        assertSame(provider, result);
        assertEquals(providerId, result.getId());

        verify(providerRepository, times(1)).findById(providerId);
    }

    @Test
    void testFindProviderByIdNotFound() {
        Long providerId = 1L;

        when(providerRepository.findById(providerId)).thenReturn(Optional.empty());

        Provider result = providerService.findById(providerId);

        assertNotNull(result);
        assertNull(result.getId());

        verify(providerRepository, times(1)).findById(providerId);
    }

    @Test
    void testUpdateProvider() {
        Long providerId = 1L;
        Provider provider = new Provider();
        provider.setId(providerId);

        when(providerRepository.save(provider)).thenReturn(provider);

        providerService.update(provider, providerId);

        verify(providerRepository, times(1)).save(provider);
    }

    @Test
    void testUpdateProviderWithMismatchedId() {
        Long providerId = 1L;
        Provider provider = new Provider();
        provider.setId(2L);

        assertThrows(RuntimeException.class, () -> providerService.update(provider, providerId));

        verify(providerRepository, never()).save(any(Provider.class));
    }

    @Test
    void testDisableProvider() {
        Long providerId = 1L;
        Provider provider = new Provider();
        provider.setId(providerId);

        when(providerRepository.findById(providerId)).thenReturn(Optional.of(provider));

        providerService.disable(providerId);

        verify(providerRepository, times(1)).findById(providerId);
        verify(providerRepository, times(1)).disable(providerId);
    }

    @Test
    void testDisableProviderWithMismatchedId() {
        Long providerId = 1L;
        Provider provider = new Provider();
        provider.setId(2L);

        when(providerRepository.findById(providerId)).thenReturn(Optional.of(provider));

        assertThrows(RuntimeException.class, () -> providerService.disable(providerId));

        verify(providerRepository, times(1)).findById(providerId);
        verify(providerRepository, never()).disable(anyLong());
    }
}
