package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Repository.CaregiverRepository;
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
public class CaregiverService implements UserDetailsService {

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Caregiver save(Caregiver caregiver) {

        Role role = new Role();
        long id = 2;
        String roleCgv = "ROLE_CAREGIVER";
        role.setId(id);
        role.setAuthority(roleCgv);
        this.roleRepository.save(role);

        caregiver.setPassword(passwordEncoder().encode(caregiver.getPassword()));

        this.caregiverRepository.save(caregiver);

        this.roleRepository.addRelationCgvWithRole(caregiver.getId(), role.getId());

        return caregiver;
    }

    public List<Caregiver> listAll() {
        return this.caregiverRepository.findAll();
    }

    public List<Caregiver> findByCaregiverActives() {
        return this.caregiverRepository.findByCaregiverActives();
    }

    public Caregiver findById(Long id) {
        return this.caregiverRepository.findById(id).orElse(new Caregiver());
    }

    @Transactional
    public void update(Long id, Caregiver caregiver){
        if (id == caregiver.getId()){
            this.caregiverRepository.save(caregiver);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var caregiver = this.caregiverRepository.findById(id);
        if (id == caregiver.get().getId()){
            this.caregiverRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return caregiverRepository.findByLogin(username);
    }

}
