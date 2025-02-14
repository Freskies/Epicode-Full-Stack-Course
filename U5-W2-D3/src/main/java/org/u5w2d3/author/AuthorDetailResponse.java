package org.u5w2d3.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.u5w2d3.post.Post;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailResponse {
	private Long id;
	private String name;
	private String surname;
	private String email;
	private LocalDate birthDate;
	private String avatarURL;
	private List<Post> posts;
}
