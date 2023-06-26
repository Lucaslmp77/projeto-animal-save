package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Admin;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.SendEmail;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    SendEmailRepository sendEmailRepository;

    @Autowired
    private JavaMailSender emailSender;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Admin saveAdmin(String loginAdmin, String senhaAdmin) {
        try{
            User user = new User();
            user.setLogin(loginAdmin);
            user.setPassword(passwordEncoder().encode(senhaAdmin));
            user.setApproved(true);
            user.setPending(false);
            user.setRejected(false);
            Role adminRole = this.roleRepository.findByAuthority("ROLE_ADMIN");
            user.getRoles().add(adminRole);
            this.userRepository.save(user);

            Admin admin = new Admin();
            admin.setName("admin");
            admin.setName("admin");
            admin.setUser(user);
            return this.adminRepository.save(admin);
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Transactional
    public Admin save(Admin admin) {
        User user = new User();
        user.setLogin(admin.getUser().getLogin());
        user.setPassword(passwordEncoder().encode(admin.getUser().getPassword()));
        Role adminRole = roleRepository.findByAuthority("ROLE_ADMIN");
        user.getRoles().add(adminRole);
        this.userRepository.save(user);

        admin.setUser(user);
        return this.adminRepository.save(admin);
    }

    public List<Admin> listAll() {
        return this.adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return this.adminRepository.findById(id).orElse(new Admin());
    }

    public List<Object> findAllPending() {
        List<Object> results = new ArrayList<>();
        results.addAll(this.adminRepository.findAssociatePending());
        results.addAll(this.adminRepository.findCaregiverPending());
        results.addAll(this.adminRepository.findProviderPending());
        return results;
    }

    @Transactional
    public void updateStatusUserPendingToApproved(Long id) {
        var user = this.userRepository.findById(id);

        SendEmail sendEmail = new SendEmail();
        sendEmail.setSendDateEmail(LocalDateTime.now());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("animalsavepi@gmail.com");
        message.setTo(user.get().getLogin());
        message.setSubject("Credenciais de acesso");
        message.setText(
                "Parabenizamos você por ter sido aprovado em nosso site! Acesse agora mesmo e aproveite os recursos " +
                "exclusivos." + "\n" + "\n" + "Login: " + user.get().getLogin() + "\n" + "Senha: "
                + user.get().getFirstCredential() + "\n" + "\n" + "Lembre-se de alterar sua senha ao fazer o primeiro " +
                "login para garantir a segurança da sua conta.\n" +
                "\n" +
                "Tenha uma ótima experiência em nosso site!" + "\n" + "Atenciosamente,\n" +
                "Equipe Animal Save\n"
        );

        emailSender.send(message);
        sendEmailRepository.save(sendEmail);

        if (id == user.get().getId()) {
            this.adminRepository.updateStatusUserPendingToApproved(id);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void updateStatusUserPendingToRejected(Long id) {
        var associate = this.userRepository.findById(id);
        if (id == associate.get().getId()) {
            this.adminRepository.updateStatusUserPendingToRejected(id);
        } else {
            throw new RuntimeException();
        }
    }

}
