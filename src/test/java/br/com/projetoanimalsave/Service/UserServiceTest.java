package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsername_ShouldReturnUserDetails_WhenUserExists() {
        String username = "lucas@example.com";
        User user = new User();
        user.setLogin(username);
        when(userRepository.findByLogin(username)).thenReturn(user);

        UserDetails userDetails = userService.loadUserByUsername(username);

        Assertions.assertEquals(user.getLogin(), userDetails.getUsername());
    }

    @Test
    void newPassword_ShouldThrowException_WhenUserIdDoesNotMatch() {
        Long userId = 1L;
        String newPassword = "newPassword";
        User user = new User();
        user.setId(2L);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.newPassword(newPassword, userId);
        });
    }

    @Test
    void findAssociateByIdUser_ShouldReturnOptionalAssociate() {
        Long userId = 1L;
        Associate associate = new Associate();
        when(userRepository.findAssociateByIdUser(userId)).thenReturn(Optional.of(associate));

        Optional<Associate> result = userService.findAssociateByIdUser(userId);

        Assertions.assertEquals(Optional.of(associate), result);
    }

    @Test
    void findCaregiverByIdUser_ShouldReturnOptionalCaregiver() {
        Long userId = 1L;
        Caregiver caregiver = new Caregiver();
        when(userRepository.findCaregiverByIdUser(userId)).thenReturn(Optional.of(caregiver));

        Optional<Caregiver> result = userService.findCaregiverByIdUser(userId);

        Assertions.assertEquals(Optional.of(caregiver), result);
    }

    @Test
    void findProviderByIdUser_ShouldReturnOptionalProvider() {
        Long userId = 1L;
        Provider provider = new Provider();
        when(userRepository.findProviderByIdUser(userId)).thenReturn(Optional.of(provider));

        Optional<Provider> result = userService.findProviderByIdUser(userId);

        Assertions.assertEquals(Optional.of(provider), result);
    }
}
