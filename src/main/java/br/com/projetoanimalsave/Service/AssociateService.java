package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Repository.AssociateRepository;
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
public class AssociateService implements UserDetailsService {
    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Associate save(Associate associate) {

        Role role = new Role();
        long id = 4;
        String roleAssoc = "ROLE_ASSOCIATE";
        role.setId(id);
        role.setAuthority(roleAssoc);
        this.roleRepository.save(role);

        associate.setPassword(passwordEncoder().encode(associate.getPassword()));

        this.associateRepository.save(associate);

        this.roleRepository.addRelationAssociateWithRole(associate.getId(), role.getId());

        return associate;
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

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return associateRepository.findByLogin(username);
    }
}
