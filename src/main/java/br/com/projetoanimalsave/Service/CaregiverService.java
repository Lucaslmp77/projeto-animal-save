package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Aprove;
import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.CaregiverRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregiverService {

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Caregiver save(Caregiver caregiver) {
        User user = new User();
        user.setLogin(caregiver.getUser().getLogin());
        user.setPassword(passwordEncoder().encode(caregiver.getUser().getPassword()));
        Role caregiverRole = roleRepository.findByAuthority("ROLE_CAREGIVER");
        user.getRoles().add(caregiverRole);
        this.userRepository.save(user);

        caregiver.setUser(user);
        caregiver.setAprove(Aprove.PENDENTE);
        return this.caregiverRepository.save(caregiver);

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
    public void update(Long id, Caregiver caregiver) {
        if (id == caregiver.getId()){
            this.caregiverRepository.save(caregiver);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var caregiver = this.caregiverRepository.findById(id);
        if (id == caregiver.get().getId()){
            this.caregiverRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }

}
