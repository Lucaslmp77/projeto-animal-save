package br.com.projetoanimalsave.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Configurations {

    @Autowired
    private FilterToken filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                //CADASTRO E LOGIN
                .requestMatchers(HttpMethod.POST, "/api/caregiver/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/provider/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/associate/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/user/login").permitAll()
                //ENDEREÇO
                .requestMatchers(HttpMethod.POST, "/api/address/register").permitAll()
                //ADMIN
                .requestMatchers(HttpMethod.POST, "/api/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/admin/**").hasAuthority("ROLE_ADMIN")
                //CUIDADOR
                .requestMatchers(HttpMethod.PUT, "/api/caregiver/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.GET, "/api/caregiver/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                //ANIMAL
                .requestMatchers(HttpMethod.POST, "/api/animal/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.PUT, "/api/animal/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.GET, "/api/animal/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                //OCORRÊNCIA
                .requestMatchers(HttpMethod.POST, "/api/occurrences/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER", "ROLE_ASSOCIATE")
                .requestMatchers(HttpMethod.GET, "/api/occurrences/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                //FORNECEDOR
                .requestMatchers(HttpMethod.PUT, "/api/provider/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                .requestMatchers(HttpMethod.GET, "/api/provider/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                //SERVIÇOS
                .requestMatchers(HttpMethod.POST, "/api/task/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                .requestMatchers(HttpMethod.PUT, "/api/task/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                .requestMatchers(HttpMethod.GET, "/api/task/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER", "ROLE_CAREGIVER")
                //ASSOCIADO
                .requestMatchers(HttpMethod.PUT, "/api/associate/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_ASSOCIATE")
                .requestMatchers(HttpMethod.GET, "/api/associate/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_ASSOCIATE")
                //QUALQUER UM COM AUTENTICAÇÃO
                .anyRequest().authenticated()
                .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager
            (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
