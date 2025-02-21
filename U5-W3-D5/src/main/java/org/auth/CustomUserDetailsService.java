package org.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		return appUserRepository.findByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con username: " + username));
	}
}
