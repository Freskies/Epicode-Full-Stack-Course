package post;

import author.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
	private Category category;
	private String title;
	private String coverURL;
	private String content;
	private int minutesToRead;
	private Author author;
}
