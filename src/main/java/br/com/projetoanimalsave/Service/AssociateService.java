package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.*;
import br.com.projetoanimalsave.Repository.AddressRepository;
import br.com.projetoanimalsave.Repository.AssociateRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AssociateService {
    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;


    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static String generateCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            code.append(randomChar);
        }

        return code.toString();
    }

    @Transactional
    public Associate save(Associate associate) {
        User user = new User();
        user.setLogin(associate.getUser().getLogin());
        user.setFirstCredential(generateCode(5));
        user.setPassword(passwordEncoder().encode(user.getFirstCredential()));
        user.setPending(true);
        user.setApproved(false);
        user.setRejected(false);
        Role associateRole = roleRepository.findByAuthority("ROLE_ASSOCIATE");
        user.getRoles().add(associateRole);
        this.userRepository.save(user);

        Address address = new Address();
        address.setCep(associate.getAddress().getCep());
        address.setNeighborhood(associate.getAddress().getNeighborhood());
        address.setRoad(associate.getAddress().getRoad());
        address.setHouseNumber(associate.getAddress().getHouseNumber());
        this.addressRepository.save(address);

        associate.setUser(user);
        associate.setAddress(address);
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
