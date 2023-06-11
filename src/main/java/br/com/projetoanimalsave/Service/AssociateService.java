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
public class AssociateService {
    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Associate save(Associate associate) {

        long idRoleAssociate = 4;


        this.associateRepository.save(associate);

        this.roleRepository.addRelationAssociateWithRole(associate.getId(), idRoleAssociate);

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
}
