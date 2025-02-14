package org.u5w2d3.runners;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.u5w2d3.author.Author;
import org.u5w2d3.author.AuthorRepository;

@Component
@RequiredArgsConstructor
@Transactional
public class CreateDatabaseRunner implements CommandLineRunner {
	private final AuthorRepository authorRepository;

	@Override
	public void run (String... args) {
		Author author1 = new Author();
		author1.setName("John");
		author1.setSurname("Doe");
		author1.setEmail("cioal@fff.tr");
		author1.setBirthDate(java.time.LocalDate.of(1990, 1, 1));
		author1.setAvatarURL("https://www.google.com");
		this.authorRepository.save(author1);
	}
}
