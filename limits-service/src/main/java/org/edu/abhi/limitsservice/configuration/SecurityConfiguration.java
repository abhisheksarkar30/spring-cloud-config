package org.edu.abhi.limitsservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private AppConfiguration config;

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails[] users = config.getUsers().stream().map(user ->
                User.withUsername(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(user.getRoles())
                        .build())
                .toArray(UserDetails[]::new);
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain apiLoginFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(request -> request
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/limits**")).hasRole(ROLE_USER) // matches user with specified role
                    .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/actuator/health")).permitAll() // matches httpMethod, not role
                    .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/actuator/env")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/actuator/**")).hasRole(ROLE_ADMIN) // matches role and httpMethod
                    .anyRequest().authenticated()) // matches any logged-in user, to be kept at the end
                .httpBasic(withDefaults())
                .sessionManagement(smConfigurer -> smConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable) // POST /actuator/refresh was not working without this
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}