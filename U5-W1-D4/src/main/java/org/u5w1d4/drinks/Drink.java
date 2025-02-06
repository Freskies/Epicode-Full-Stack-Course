package org.u5w1d4.drinks;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Drink")
public class Drink {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (nullable = false)
	private Long id;

	private String name;
	private String type;
	private double price;

	public Drink (String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	@Override
	public final boolean equals (Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Drink drink = (Drink) o;
		return getId() != null && Objects.equals(getId(), drink.getId());
	}

	@Override
	public final int hashCode () {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
