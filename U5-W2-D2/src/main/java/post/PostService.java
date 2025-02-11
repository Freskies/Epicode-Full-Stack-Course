package post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;

	public Post save (PostRequest postRequest) {
		Post post = new Post();
		BeanUtils.copyProperties(postRequest, post);
		return postRepository.save(post);
	}

	public Post findById (Long id) {
		return postRepository.findById(id).orElse(null);
	}

	public List<Post> findAll () {
		return postRepository.findAll();
	}
}
