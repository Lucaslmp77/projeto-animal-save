package br.com.projetoanimalsave.Utils;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.AdminRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import br.com.projetoanimalsave.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminService adminService;

    @Override
    public void run(String... args) {
        this.createDefaultUser();
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void createDefaultUser() {
        Role roleAdmin = this.roleRepository.findByAuthority("ROLE_ADMIN");
        Role roleCaregiver = this.roleRepository.findByAuthority("ROLE_CAREGIVER");
        Role roleProvider = this.roleRepository.findByAuthority("ROLE_PROVIDER");
        Role roleAssociate = this.roleRepository.findByAuthority("ROLE_ASSOCIATE");

        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setAuthority("ROLE_ADMIN");
            this.roleRepository.save(roleAdmin);
        }

        if (roleCaregiver == null) {
            roleCaregiver = new Role();
            roleCaregiver.setAuthority("ROLE_CAREGIVER");
            this.roleRepository.save(roleCaregiver);
        }

        if (roleProvider == null) {
            roleProvider = new Role();
            roleProvider.setAuthority("ROLE_PROVIDER");
            this.roleRepository.save(roleProvider);
        }

        if (roleAssociate == null) {
            roleAssociate = new Role();
            roleAssociate.setAuthority("ROLE_ASSOCIATE");
            this.roleRepository.save(roleAssociate);
        }

        User existingUser = userRepository.findByLogin("admin@admin.com");

        if (existingUser == null) {
            User user = new User();
            user.setLogin("admin@admin.com");
            user.setPassword(passwordEncoder().encode("admin"));
            user.setApproved(true);
            user.setPending(false);
            user.setRejected(false);
            Role adminRole = this.roleRepository.findByAuthority("ROLE_ADMIN");
            user.getRoles().add(adminRole);
            this.userRepository.save(user);

            Admin admin = new Admin();
            admin.setName("admin");
            admin.setUser(user);
            this.adminRepository.save(admin);
        }
    }
}