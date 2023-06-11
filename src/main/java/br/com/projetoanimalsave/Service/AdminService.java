package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Repository.AdminRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements UserDetailsService{
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Admin save(Admin admin) {

        Role role = new Role();
        long idRoleAdm = 1;
        String roleAdm = "ROLE_ADMIN";
        role.setId(idRoleAdm);
        role.setAuthority(roleAdm);
        this.roleRepository.save(role);

        admin.setPassword(passwordEncoder().encode(admin.getPassword()));

        this.adminRepository.save(admin);

        this.roleRepository.addRelationAdmWithRole(admin.getId(), role.getId());

        return admin;
    }

    public List<Admin> listAll() {
        return this.adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return this.adminRepository.findById(id).orElse(new Admin());
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return adminRepository.findByLogin(username);
    }
}
