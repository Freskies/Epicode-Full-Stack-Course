"use strict";

class Car {
	constructor(make, speed) {
		this.make = make;
		this.speed = speed;
	}

	// GETTER

	get make() {
		return this._make;
	}

	get speed() {
		return this._speed;
	}

	get speedUS() {
		return this.speed / 1.6;
	}

	// SETTER

	set make(make) {
		this._make = make;
	}

	set speed(speed) {
		this._speed = speed;
	}

	set speedUS(speedUS) {
		this.speed = speedUS * 1.6;
	}

	accelerate() {
		this.speed += 10;
		this.logSpeed();
	}

	brake() {
		this.speed -= 5;
		this.logSpeed();
	}

	logSpeed() {
		console.log(this.speed);
	}
}

const bmw = new Car("BMW", 120);
const mercedes = new Car("Mercedes", 95);

bmw.accelerate();
bmw.accelerate();
mercedes.brake();

console.log(bmw.speed);
console.log(bmw.speedUS);
bmw.speedUS = 120;
console.log(bmw.speedUS, bmw.speed);
