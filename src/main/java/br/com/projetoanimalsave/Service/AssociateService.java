package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Aprove;
import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.AssociateRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociateService {
    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Associate save(Associate associate) {
        User user = new User();
        user.setLogin(associate.getUser().getLogin());
        user.setPassword(passwordEncoder().encode(associate.getUser().getPassword()));
        Role associateRole = roleRepository.findByAuthority("ROLE_ASSOCIATE");
        user.getRoles().add(associateRole);
        this.userRepository.save(user);

        associate.setUser(user);
        associate.setAprove(Aprove.PENDENTE);
        return this.associateRepository.save(associate);
    }

    public List<Associate> listAll() {
        return this.associateRepository.findAll();
    }

    public Associate findById(Long id) {
        return this.associateRepository.findById(id).orElse(new Associate());
    }

    @Transactional
    public void update(Associate associate, Long id) {
        if (id == associate.getId()){
            this.associateRepository.save(associate);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var associate = this.associateRepository.findById(id);
        if (id == associate.get().getId()) {
            this.associateRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }
}
