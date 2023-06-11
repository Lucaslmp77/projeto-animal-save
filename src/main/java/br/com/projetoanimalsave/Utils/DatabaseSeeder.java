package br.com.projetoanimalsave.Utils;

import br.com.projetoanimalsave.Entity.Role;
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
    AdminService adminService;

    @Override
    public void run(String... args) {
        this.createDefaultUser();
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void createDefaultUser() {
        Role roleAdmin = new Role();
        Role roleCaregiver = new Role();
        Role roleProvider = new Role();
        Role roleAssociate = new Role();

        roleAdmin.setAuthority("ROLE_ADMIN");
        roleCaregiver.setAuthority("ROLE_CAREGIVER");
        roleProvider.setAuthority("ROLE_PROVIDER");
        roleAssociate.setAuthority("ROLE_ASSOCIATE");

        this.roleRepository.save(roleAdmin);
        this.roleRepository.save(roleCaregiver);
        this.roleRepository.save(roleProvider);
        this.roleRepository.save(roleAssociate);

        this.adminService.saveAdmin("admin@admin.com", "admin");
    }
}