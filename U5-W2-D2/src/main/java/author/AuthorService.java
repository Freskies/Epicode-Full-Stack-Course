package author;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
	private final AuthorRepository authorRepository;

	public Author save (AuthorRequest authorRequest) {
		Author author = new Author();
		BeanUtils.copyProperties(authorRequest, author);
		author.generateAvatarURL();
		return authorRepository.save(author);
	}

	public Author findById (Long id) {
		return authorRepository.findById(id).orElse(null);
	}

	public List<Author> findAll () {
		return authorRepository.findAll();
	}

	public Author update (Long id, AuthorRequest authorRequest) {
		Author author = this.findById(id);
		if (author == null) return null;
		BeanUtils.copyProperties(authorRequest, author);
		author.generateAvatarURL();
		return authorRepository.save(author);
	}

	public void delete (Long id) {
		authorRepository.deleteById(id);
	}
}
