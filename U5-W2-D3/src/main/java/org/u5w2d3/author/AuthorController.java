package org.u5w2d3.author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.u5w2d3.reponse.CreateResponse;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
	private final AuthorService authorService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AuthorResponse> findAll () {
		return this.authorService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateResponse save (@RequestBody AuthorRequest authorRequest) {
		return this.authorService.save(authorRequest);
	}
}
