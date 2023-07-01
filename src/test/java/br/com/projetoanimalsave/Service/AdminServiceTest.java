package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.AdminRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private AdminService adminService;

    @Test
    public void saveAdmin() {

        User user = new User();
        user.setLogin("lucas@example.com");
        user.setPassword("luska");
        user.setApproved(true);
        user.setPending(false);
        user.setRejected(false);
        Role adminRole = new Role();
        adminRole.setAuthority("ROLE_ADMIN");
        user.getRoles().add(adminRole);

        Admin admin = new Admin();
        admin.setUser(user);
        admin.setName("Lucas");

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin savedAdmin = adminService.save(admin);

        assertEquals(user.getId(), savedAdmin.getUser().getId());
        assertEquals(user.getLogin(), savedAdmin.getUser().getLogin());
        assertEquals("Lucas", savedAdmin.getName());

        verify(userRepository, times(1)).save(any(User.class));
        verify(adminRepository, times(1)).save(any(Admin.class));
    }


    @Test
    public void listAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin());
        admins.add(new Admin());

        when(adminRepository.findAll()).thenReturn(admins);

        List<Admin> result = adminService.listAll();

        assertEquals(2, result.size());
        assertEquals(admins, result);

        verify(adminRepository, times(1)).findAll();
    }

    @Test
    public void findAdminById() {
        Admin admin = new Admin();
        admin.setId(1L);

        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        Admin result = adminService.findById(1L);

        assertNotNull(result);
        assertEquals(admin, result);

        verify(adminRepository, times(1)).findById(1L);
    }
}
