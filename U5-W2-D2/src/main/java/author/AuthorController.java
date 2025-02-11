package author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
	private final AuthorService authorService;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<Author> findAll () {
		return this.authorService.findAll();
	}

	@GetMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public Author findById (@PathVariable Long id) {
		return this.authorService.findById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public Author save (@RequestBody AuthorRequest request) {
		return this.authorService.save(request);
	}
}
