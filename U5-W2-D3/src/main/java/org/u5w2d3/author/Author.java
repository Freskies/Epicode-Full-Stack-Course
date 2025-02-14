package org.u5w2d3.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.u5w2d3.post.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "authors")
public class Author {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (nullable = false)
	private Long id;

	private String name;

	private String surname;

	private String email;

	private LocalDate birthDate;

	private String avatarURL;

	@OneToMany (mappedBy = "author")
	@ToString.Exclude
	@JsonIgnoreProperties ({"author"})
	private List<Post> posts;

	@Override
	public final boolean equals (Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Author author = (Author) o;
		return getId() != null && Objects.equals(getId(), author.getId());
	}

	@Override
	public final int hashCode () {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
