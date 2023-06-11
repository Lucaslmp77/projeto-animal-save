package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.Aprove;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Admin saveAdmin(String loginAdmin, String senhaAdmin) {
            User user = new User();
            user.setLogin(loginAdmin);
            user.setPassword(passwordEncoder().encode(senhaAdmin));
            Role adminRole = this.roleRepository.findByAuthority("ROLE_ADMIN");
            user.getRoles().add(adminRole);
            this.userRepository.save(user);

            Admin admin = new Admin();
            admin.setName("admin");
            admin.setUser(user);
            return this.adminRepository.save(admin);
    }

    @Transactional
    public Admin save(Admin admin) {
        User user = new User();
        user.setLogin(admin.getUser().getLogin());
        user.setPassword(passwordEncoder().encode(admin.getUser().getPassword()));
        Role adminRole = roleRepository.findByAuthority("ROLE_ADMIN");
        user.getRoles().add(adminRole);
        this.userRepository.save(user);

        admin.setUser(user);
        return this.adminRepository.save(admin);
    }

    public List<Admin> listAll() {
        return this.adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return this.adminRepository.findById(id).orElse(new Admin());
    }

    public List<Object> findAllPending() {
        List<Object> results = new ArrayList<>();
        results.addAll(this.adminRepository.findAssociatePending(Aprove.PENDENTE));
        results.addAll(this.adminRepository.findCaregiverPending(Aprove.PENDENTE));
        results.addAll(this.adminRepository.findProviderPending(Aprove.PENDENTE));
        return results;
    }

}
