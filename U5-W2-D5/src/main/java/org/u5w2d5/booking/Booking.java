package org.u5w2d5.booking;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.u5w2d5.employee.Employee;
import org.u5w2d5.travel.Travel;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity (name = "bookings")
public class Booking {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (nullable = false)
	private Long id;

	private LocalDate requestedAt = LocalDate.now();
	private String notes;

	@ManyToOne
	private Travel travel;

	@ManyToOne
	private Employee employee;

	@Override
	public final boolean equals (Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Booking booking = (Booking) o;
		return getId() != null && Objects.equals(getId(), booking.getId());
	}

	@Override
	public final int hashCode () {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
