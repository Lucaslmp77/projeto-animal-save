package br.com.projetoanimalsave.Utils;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    AdminService adminService;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        this.createDefaultUser();
    }

    private void createDefaultUser() {
        try {
            Admin admin = new Admin();

            admin.setName("admin");
            admin.setLogin("admin@admin.com");
            admin.setPassword("admin");

            admin = this.adminService.save(admin);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}