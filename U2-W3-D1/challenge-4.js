"use strict";

class Car {
	constructor(make, speed) {
		this.make = make;
		this.speed = speed;
	}

	accelerate() {
		this.speed += 20;
		return this;
	}
}

class ElectricCar extends Car {
	#charge;

	constructor(make, speed, charge) {
		super(make, speed);
		this.#charge = charge;
	}

	get charge() {
		return this.#charge;
	}

	accelerate() {
		this.#charge -= 5;
		return super.accelerate();
	}
}

const tesla = new ElectricCar("tesla", 100, 75);
tesla.accelerate().accelerate();
console.log(tesla.charge);
