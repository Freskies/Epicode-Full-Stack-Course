"use strict";

class Account {
	#owner;
	#currency;
	#pin;
	#movements = [];
	locale = navigator.language;

	constructor(owner, currency, pin) {
		this.#owner = owner;
		this.#currency = currency;
		this.#pin = pin;
	}

	deposit(value) {
		this.#movements.push(value);
		return this;
	}

	withdrowal(value) {
		this.deposit(-Math.abs(value));
		return this;
	}

	#approveLoan(value) {
		return true;
	}

	requestLoan(value) {
		if (this.#approveLoan(value)) {
			this.deposit(value);
			console.log("Loan Approved");
		}
		return this;
	}
}

const acc1 = new Account("Jonas", "EUR", 1111);
acc1.deposit(250);
acc1.withdrowal(120);
acc1.withdrowal(-80);

console.log(acc1);

acc1.deposit(15).deposit(400).requestLoan(500);
console.log(acc1);
