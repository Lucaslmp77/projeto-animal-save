package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public Admin save(Admin admin) {
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

    @Transactional
    public void delete(Admin admin, Long id) {
        if (id == admin.getId()) {
            this.adminRepository.delete(admin);
        } else {
            throw new RuntimeException();
        }
    }
}
