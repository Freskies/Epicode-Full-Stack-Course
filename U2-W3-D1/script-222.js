"use strict";

const PersonProto = {
	init(firstName, birthYear) {
		this.firstName = firstName;
		this.birthYear = birthYear;
	},

	calcAge() {
		return new Date().getFullYear() - this.birthYear;
	},
};

const steven = Object.create(PersonProto);

const StudentProto = Object.create(PersonProto);

StudentProto.init = function (firstName, birthYear, course) {
	PersonProto.init.call(this, firstName, birthYear);
	this.course = course;
};

StudentProto.introduce = function () {
	// code
};

const jay = Object.create(StudentProto);
jay.init("Jay", 2010, "Computer Science");
console.log(jay);
