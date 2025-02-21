package org.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AuthRunner implements ApplicationRunner {
	private final AppUserService appUserService;
	// private final PasswordEncoder passwordEncoder;

	@Override
	public void run (ApplicationArguments args) {
		this.appUserService.findByUsername("admin").orElseGet(() ->
			this.appUserService.registerUser("admin", "adminpwd", Set.of(Role.ADMIN))
		);

		this.appUserService.findByUsername("user").orElseGet(() ->
			this.appUserService.registerUser("user", "userpwd", Set.of(Role.USER))
		);

		this.appUserService.findByUsername("organizer").orElseGet(() ->
			this.appUserService.registerUser("organizer", "organizerpwd", Set.of(Role.ORGANIZER))
		);
	}
}
