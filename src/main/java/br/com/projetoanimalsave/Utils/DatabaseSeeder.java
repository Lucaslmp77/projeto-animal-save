package br.com.projetoanimalsave.Utils;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
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

    @Override
    public void run(String... args) {
        this.createDefaultUser();
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void createDefaultUser() {

        try {
            User user = new User();

            user.setLogin("admin@admin.com");

            user.setPassword(passwordEncoder().encode("admin"));

            this.userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        Role roleCaregiver = new Role();
        Role roleProvider = new Role();
        Role roleAssociate = new Role();

        roleCaregiver.setAuthority("ROLE_CAREGIVER");
        roleProvider.setAuthority("ROLE_PROVIDER");
        roleAssociate.setAuthority("ROLE_ASSOCIATE");

        this.roleRepository.save(roleCaregiver);
        this.roleRepository.save(roleProvider);
        this.roleRepository.save(roleAssociate);
    }
}