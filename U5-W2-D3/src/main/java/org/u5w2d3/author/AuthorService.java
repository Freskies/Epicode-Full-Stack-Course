package org.u5w2d3.author;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.u5w2d3.reponse.CreateResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
	private final AuthorRepository authorRepository;

	public Author authorFromRequest (AuthorRequest authorRequest) {
		Author author = new Author();
		BeanUtils.copyProperties(authorRequest, author);
		return author;
	}

	public AuthorResponse authorResponseFromEntity (Author author) {
		AuthorResponse authorResponse = new AuthorResponse();
		BeanUtils.copyProperties(author, authorResponse);
		return authorResponse;
	}

	public AuthorDetailResponse authorDetailResponseFromEntity (Author author) {
		AuthorDetailResponse authorDetailResponse = new AuthorDetailResponse();
		BeanUtils.copyProperties(author, authorDetailResponse);
		return authorDetailResponse;
	}

	public List<AuthorResponse> authorResponseListFromEntityList (@NotNull List<Author> authors) {
		return authors.stream().map(this::authorResponseFromEntity).toList();
	}

	// find all authors

	public List<AuthorResponse> findAll () {
		return this.authorResponseListFromEntityList(this.authorRepository.findAll());
	}

	public AuthorResponse findById (Long id) {
		return this.authorResponseFromEntity(
			this.authorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Author not found"))
		);
	}

	@Transactional
	public AuthorDetailResponse findDetailById (Long id) {
		return this.authorDetailResponseFromEntity(
			this.authorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Author not found"))
		);
	}

	public CreateResponse save (AuthorRequest authorRequest) {
		Author author = this.authorFromRequest(authorRequest);
		return new CreateResponse(author.getId());
	}

	public CreateResponse update (Long id, AuthorRequest authorRequest) {
		Author author = this.authorRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Author not found"));
		BeanUtils.copyProperties(authorRequest, author);
		return new CreateResponse(author.getId());
	}

	public void deleteById (Long id) {
		if (!this.authorRepository.existsById(id))
			throw new EntityNotFoundException("Author not found");
		this.authorRepository.deleteById(id);
	}

}
