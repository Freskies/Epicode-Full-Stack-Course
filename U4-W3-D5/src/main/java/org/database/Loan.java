package org.database;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "loans")
public class Loan {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Integer id;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "isbn")
	private Publication isbn;

	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@OnDelete (action = OnDeleteAction.SET_NULL)
	@JoinColumn (name = "user_id", nullable = false)
	private User user;

	@Column (name = "loan_date", nullable = false)
	private LocalDate loanDate;

	@Column (name = "excepted_return_date", nullable = false)
	private LocalDate exceptedReturnDate;

	@Column (name = "effective_return_date")
	private LocalDate effectiveReturnDate;

	public Loan () {
	}

	public Loan (Publication isbn, User user, @NotNull LocalDate loanDate) {
		this.isbn = isbn;
		this.user = user;
		this.loanDate = loanDate;
		this.exceptedReturnDate = loanDate.plusDays(30);
	}

	public LocalDate getEffectiveReturnDate () {
		return effectiveReturnDate;
	}

	public void setEffectiveReturnDate (LocalDate effectiveReturnDate) {
		this.effectiveReturnDate = effectiveReturnDate;
	}

	public LocalDate getExceptedReturnDate () {
		return exceptedReturnDate;
	}

	public void setExceptedReturnDate (LocalDate exceptedReturnDate) {
		this.exceptedReturnDate = exceptedReturnDate;
	}

	public LocalDate getLoanDate () {
		return loanDate;
	}

	public void setLoanDate (LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public User getUser () {
		return user;
	}

	public void setUser (User user) {
		this.user = user;
	}

	public Integer getId () {
		return id;
	}

	public void setId (Integer id) {
		this.id = id;
	}

	public Publication getIsbn () {
		return isbn;
	}

	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Loan loan)) return false;
		return Objects.equals(getId(), loan.getId()) && Objects.equals(getIsbn(), loan.getIsbn()) && Objects.equals(getUser(), loan.getUser()) && Objects.equals(getLoanDate(), loan.getLoanDate()) && Objects.equals(getExceptedReturnDate(), loan.getExceptedReturnDate()) && Objects.equals(getEffectiveReturnDate(), loan.getEffectiveReturnDate());
	}

	@Override
	public int hashCode () {
		return Objects.hash(getId(), getIsbn(), getUser(), getLoanDate(), getExceptedReturnDate(), getEffectiveReturnDate());
	}

	@Override
	public String toString () {
		return "Loan{" +
			"id=" + getId() +
			", isbn=" + getIsbn() +
			", user=" + getUser() +
			", loanDate=" + getLoanDate() +
			", exceptedReturnDate=" + getExceptedReturnDate() +
			", effectiveReturnDate=" + getEffectiveReturnDate() +
			'}';
	}
}