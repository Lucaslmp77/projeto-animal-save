package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Repository.AdminRepository;
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

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Admin save(Admin admin) {
        admin.setPassword(passwordEncoder().encode(admin.getPassword()));
        return this.adminRepository.save(admin);
    }

    public List<Admin> listAll() {
        return this.adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return this.adminRepository.findById(id).orElse(new Admin());
    }

    @Transactional
    public void update(Admin admin, Long id) {
        if (id == admin.getId()) {
            this.adminRepository.save(admin);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return adminRepository.findByLogin(username);
    }
}
