package br.com.projetoanimalsave.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private FilterToken filter;

    @Value("${cors.origins}")
    private String corsOrigins;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests()
                //CADASTRO E LOGIN
                .requestMatchers(HttpMethod.POST, "/api/caregiver/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/provider/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/associate/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/user/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/user/**").permitAll()
                //ENDEREÇO
                .requestMatchers(HttpMethod.POST, "/api/address/register").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/address/**").permitAll()
                //ADMIN
                .requestMatchers(HttpMethod.POST, "/api/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/user/findAssociateByIdUser/{idUser}").permitAll()
                //CUIDADOR
                .requestMatchers(HttpMethod.PUT, "/api/caregiver/update")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.PUT, "/api/caregiver/disable")
                .hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/caregiver/listall")
                .hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/caregiver/findbyid/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                //ANIMAL
                .requestMatchers(HttpMethod.POST, "/api/animal/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.PUT, "/api/animal/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.GET, "/api/animal/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                //OCORRÊNCIA
                .requestMatchers(HttpMethod.POST, "/api/occurrence/**")
                .permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/occurrence/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.GET, "/api/occurrence/listall")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                .requestMatchers(HttpMethod.GET, "/api/occurrence/findbyid/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_CAREGIVER")
                //FORNECEDOR
                .requestMatchers(HttpMethod.PUT, "/api/provider/update")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                .requestMatchers(HttpMethod.PUT, "/api/provider/disable")
                .hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/provider/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                //SERVIÇOS
                .requestMatchers(HttpMethod.POST, "/api/task/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                .requestMatchers(HttpMethod.PUT, "/api/task/update")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER")
                .requestMatchers(HttpMethod.PUT, "/api/task/disable")
                .hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/task/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_PROVIDER", "ROLE_CAREGIVER")
                //ASSOCIADO
                .requestMatchers(HttpMethod.PUT, "/api/associate/**")
                .permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/associate/disable")
                .hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/associate/listall")
                .hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/associate/findbyid/**")
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

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        String[] origins = corsOrigins.split(",");

        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOriginPatterns(Arrays.asList(origins));
        corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD",
                "TRACE", "CONNECT"));
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
                new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
