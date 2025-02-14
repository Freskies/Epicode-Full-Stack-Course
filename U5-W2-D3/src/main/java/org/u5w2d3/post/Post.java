package org.u5w2d3.post;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.u5w2d3.author.Author;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "posts")
public class Post {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (nullable = false)
	private Long id;

	private String title;

	private String content;

	private String cover;

	private String category;

	private int readTimeMinutes;

	@ManyToOne
	private Author author;

	@Override
	public final boolean equals (Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Post post = (Post) o;
		return getId() != null && Objects.equals(getId(), post.getId());
	}

	@Override
	public final int hashCode () {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
