package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Repository.ProviderRepository;
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
public class ProviderService implements UserDetailsService {
    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Provider save(Provider provider) {

        Role role = new Role();
        long id = 3;
        String roleProv = "ROLE_PROVIDER";
        role.setId(id);
        role.setAuthority(roleProv);
        this.roleRepository.save(role);

        provider.setPassword(passwordEncoder().encode(provider.getPassword()));

        this.providerRepository.save(provider);

        this.roleRepository.addRelationProviderWithRole(provider.getId(), role.getId());

        return provider;
    }

    public List<Provider> listAll() {
        return this.providerRepository.findAll();
    }

    public Provider findById(Long id) {
        return this.providerRepository.findById(id).orElse(new Provider());
    }

    @Transactional
    public void update(Provider provider, Long id){
        if (id == provider.getId()) {
            this.providerRepository.save(provider);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var provider = this.providerRepository.findById(id);
        if (id == provider.get().getId()) {
            this.providerRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return providerRepository.findByLogin(username);
    }
}