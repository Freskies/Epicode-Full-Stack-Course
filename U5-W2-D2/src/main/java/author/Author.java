package author;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import post.Post;

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

	@Column (nullable = false)
	private String name;

	@Column (nullable = false)
	private String surname;

	@Column (nullable = false)
	private String email;

	@Column (nullable = false)
	private LocalDate birthdate;

	@Column (nullable = false, updatable = false)
	private String avatarURL;

	public void generateAvatarURL () {
		this.setAvatarURL("https://ui-avatars.com/api/?name=" + this.getName() + "+" + this.getSurname());
	}

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
