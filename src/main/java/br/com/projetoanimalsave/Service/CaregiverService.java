package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.*;
import br.com.projetoanimalsave.Repository.*;
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

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private GenerateCodeService generateCodeService;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Caregiver save(Caregiver caregiver) {
        User user = new User();
        user.setLogin(caregiver.getUser().getLogin());
        user.setFirstCredential(generateCodeService.generateCode(7));
        user.setPassword(passwordEncoder().encode(user.getFirstCredential()));
        user.setPending(true);
        user.setApproved(false);
        user.setRejected(false);
        Role caregiverRole = roleRepository.findByAuthority("ROLE_CAREGIVER");
        user.getRoles().add(caregiverRole);
        this.userRepository.save(user);

        Address address = new Address();
        address.setCep(caregiver.getAddress().getCep());
        address.setNeighborhood(caregiver.getAddress().getNeighborhood());
        address.setRoad(caregiver.getAddress().getRoad());
        address.setHouseNumber(caregiver.getAddress().getHouseNumber());
        this.addressRepository.save(address);

        caregiver.setUser(user);
        caregiver.setAddress(address);
        return this.caregiverRepository.save(caregiver);
    }

    public List<Caregiver> listAll() {
        return this.caregiverRepository.findAll();
    }

    public List<Caregiver> findByCaregiverActives() {
        return this.caregiverRepository.findByCaregiverActives();
    }

    public List<Caregiver> findByCaregiverInactives() {
        return this.caregiverRepository.findByCaregiverInactives();
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
