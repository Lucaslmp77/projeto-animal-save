package br.com.projetoanimalsave.Utils;

import br.com.projetoanimalsave.Entity.*;
import br.com.projetoanimalsave.Repository.*;
import br.com.projetoanimalsave.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    AssociateRepository associateRepository;

    @Autowired
    CaregiverRepository caregiverRepository;
    @Autowired
    AdminService adminService;

    @Override
    public void run(String... args) {
        this.createDefaultUser();
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void createDefaultUser() {
        Role roleAdmin = this.roleRepository.findByAuthority("ROLE_ADMIN");
        Role roleCaregiver = this.roleRepository.findByAuthority("ROLE_CAREGIVER");
        Role roleProvider = this.roleRepository.findByAuthority("ROLE_PROVIDER");
        Role roleAssociate = this.roleRepository.findByAuthority("ROLE_ASSOCIATE");

        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setAuthority("ROLE_ADMIN");
            this.roleRepository.save(roleAdmin);
        }

        if (roleCaregiver == null) {
            roleCaregiver = new Role();
            roleCaregiver.setAuthority("ROLE_CAREGIVER");
            this.roleRepository.save(roleCaregiver);
        }

        if (roleProvider == null) {
            roleProvider = new Role();
            roleProvider.setAuthority("ROLE_PROVIDER");
            this.roleRepository.save(roleProvider);
        }

        if (roleAssociate == null) {
            roleAssociate = new Role();
            roleAssociate.setAuthority("ROLE_ASSOCIATE");
            this.roleRepository.save(roleAssociate);
        }

        User existingUser = userRepository.findByLogin("admin@admin.com");

        if (existingUser == null) {
            User user = new User();
            user.setLogin("admin@admin.com");
            user.setPassword(passwordEncoder().encode("admin"));
            user.setApproved(true);
            user.setPending(false);
            user.setRejected(false);
            Role adminRole = this.roleRepository.findByAuthority("ROLE_ADMIN");
            user.getRoles().add(adminRole);
            this.userRepository.save(user);

            Admin admin = new Admin();
            admin.setName("admin");
            admin.setUser(user);
            this.adminRepository.save(admin);
        }

        User existingProvider = userRepository.findByLogin("provider@provider.com");

        if (existingProvider == null) {
            User user = new User();
            user.setLogin("provider@provider.com");
            user.setPassword(passwordEncoder().encode("provider"));
            user.setPending(false);
            user.setApproved(true);
            user.setRejected(false);
            Role providerRole = roleRepository.findByAuthority("ROLE_PROVIDER");
            user.getRoles().add(providerRole);
            this.userRepository.save(user);

            Address address = new Address();
            address.setCep("00000000");
            address.setNeighborhood("Bairro do provider");
            address.setRoad("Rua do provider");
            address.setHouseNumber(55);
            this.addressRepository.save(address);

            Provider provider = new Provider();
            provider.setUser(user);
            provider.setAddress(address);
            provider.setFantasyName("Provider fantasy");
            provider.setBusinessName("Provider business");
            provider.setCnpj("77.752.293/0001-98");
            provider.setContact("00 0 00000000");
            this.providerRepository.save(provider);
        }

        User existingAssociate = userRepository.findByLogin("associate@associate.com");

        if (existingAssociate == null) {
            User user = new User();
            user.setLogin("associate@associate.com");
            user.setPassword(passwordEncoder().encode("associate"));
            user.setPending(false);
            user.setApproved(true);
            user.setRejected(false);
            Role associateRole = roleRepository.findByAuthority("ROLE_ASSOCIATE");
            user.getRoles().add(associateRole);
            this.userRepository.save(user);

            Address address = new Address();
            address.setCep("00000000");
            address.setNeighborhood("Bairro do associado");
            address.setRoad("Rua do associado");
            address.setHouseNumber(33);
            this.addressRepository.save(address);

            Associate associate = new Associate();
            associate.setUser(user);
            associate.setAddress(address);
            associate.setFirstName("Associado");
            associate.setLastName("Sobrenome");
            associate.setContact("00 0 00000000");
            associate.setCpf("274.198.560-01");
            this.associateRepository.save(associate);
        }

        User existingCaregiver = userRepository.findByLogin("caregiver@caregiver.com");

        if (existingCaregiver == null) {
            User user = new User();
            user.setLogin("caregiver@caregiver.com");
            user.setPassword(passwordEncoder().encode("caregiver"));
            user.setPending(false);
            user.setApproved(true);
            user.setRejected(false);
            Role caregiverRole = roleRepository.findByAuthority("ROLE_CAREGIVER");
            user.getRoles().add(caregiverRole);
            this.userRepository.save(user);

            Address address = new Address();
            address.setCep("00000000");
            address.setNeighborhood("Bairro da protetora");
            address.setRoad("Rua da protetora");
            address.setHouseNumber(99);
            this.addressRepository.save(address);

            Caregiver caregiver = new Caregiver();
            caregiver.setUser(user);
            caregiver.setAddress(address);
            caregiver.setFirstName("Caregiver");
            caregiver.setLastName("Sobrenome");
            caregiver.setContact("00 0 00000000");
            caregiver.setCpf("461.171.680-55");
            caregiver.setPhysicalSpace("50 metros");
            caregiver.setSpending("4.000,00");
            caregiver.setCapacityAnimals(50.0);
            this.caregiverRepository.save(caregiver);
        }
    }
}