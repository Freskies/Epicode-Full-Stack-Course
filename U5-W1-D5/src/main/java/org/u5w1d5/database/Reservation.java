package org.u5w1d5.database;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (nullable = false)
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Workstation workstation;

	private LocalDate reservationDate;

	public Reservation (User user, Workstation workstation, LocalDate reservationDate) {
		this.user = user;
		this.workstation = workstation;
		this.reservationDate = reservationDate;
	}

	@Override
	public final boolean equals (Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy
			? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy
			? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Reservation that = (Reservation) o;
		return this.getId() != null && Objects.equals(this.getId(), that.getId());
	}

	@Override
	public final int hashCode () {
		return this instanceof HibernateProxy
			? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
			: this.getClass().hashCode();
	}
}
