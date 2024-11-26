package be.ehb.enterpriseapp.config;

import be.ehb.enterpriseapp.auth.enums.UserRole;
import be.ehb.enterpriseapp.auth.services.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, JpaUserDetailsService jpaUserDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jpaUserDetailsService = jpaUserDetailsService;
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .securityMatcher("/**")
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                    .requestMatchers("/api/products").permitAll()
                    .requestMatchers("/auth/login").permitAll()
                    .requestMatchers("/admin/**").hasRole(UserRole.ADMIN.name())
                    .anyRequest().authenticated()
            );

         return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
         return http.getSharedObject(AuthenticationManagerBuilder.class)
                    .userDetailsService(jpaUserDetailsService)
                    .passwordEncoder(passwordEncoder())
                    .and()
                    .build();
    }
}


