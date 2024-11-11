"use strict";

function Car(make, speed) {
	this.make = make;
	this.speed = speed;
}

Car.prototype.accelerate = function () {
	this.speed += 20;
};

function ElecticCar(make, speed, charge) {
	Car.call(this, make, speed);
	this.charge = charge;
}

ElecticCar.prototype = Object.create(Car.prototype);
ElecticCar.prototype.constructor = ElecticCar;

ElecticCar.prototype.chargeBattery = function (chargeTo) {
	this.charge = chargeTo;
};

ElecticCar.prototype.accelerate = function () {
	this.speed += 20;
	this.charge--;
};

const tesla = new ElecticCar("Tesla", 120, 100);

tesla.accelerate();
tesla.accelerate();
console.log(tesla.speed, tesla.charge);
