package com.example.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig - Configures Spring Security for the Employee Management Web Application.
 *
 * - Provides a custom login page at /login
 * - Redirects to /employees after successful login
 * - In-memory user: admin / admin123
 * - Passwords are encoded with BCrypt
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Defines the security filter chain.
     *
     * - All requests require authentication except the login page
     * - Custom form-based login at /login
     * - Logout redirects back to /login
     * - REST API endpoints also require authentication
     *
     * @param http - the HttpSecurity builder
     * @return SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Allow login page without authentication; everything else requires login
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )

            // Custom form login configuration
            .formLogin(form -> form
                .loginPage("/login")                   // Our custom login page
                .defaultSuccessUrl("/employees", true) // Redirect here after login
                .failureUrl("/login?error=true")       // Redirect here on bad credentials
                .permitAll()
            )

            // Logout configuration
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }

    /**
     * Creates an in-memory user store with a single admin user.
     *
     * Credentials:
     *   username : admin
     *   password : admin123
     *   role     : ADMIN
     *
     * @return UserDetailsService with the admin user registered
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails adminUser = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin123"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(adminUser);
    }

    /**
     * BCrypt password encoder bean.
     * Used to securely encode the admin password.
     *
     * @return PasswordEncoder (BCrypt)
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
