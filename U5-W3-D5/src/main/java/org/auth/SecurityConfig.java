package org.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private CustomUserDetailsService customUserDetailsService;
	private JwtRequestFilter jwtRequestFilter;


	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

		http
			.csrf(AbstractHttpConfigurer::disable) // Disabilita CSRF
			.authorizeHttpRequests(authorize -> authorize
				//.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Accesso libero a Swagger
				//.requestMatchers("/api/**").permitAll()
				.anyRequest().permitAll()
			)
			.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			);

		// Aggiungi il filtro JWT
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
}
