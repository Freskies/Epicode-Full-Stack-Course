"use strict";

const Person = function (firstName, birthYear) {
	this.firstName = firstName;
	this.birthYear = birthYear;
};

Person.prototype.calcAge = function () {
	return new Date().getFullYear() - this.birthYear;
};

const Student = function (firstName, birthYear, course) {
	Person.call(this, firstName, birthYear);
	this.course = course;
};

Student.prototype = Object.create(Person.prototype);

Student.prototype.constructor = Student;
console.dir(Student.prototype.constructor);

Student.prototype.introduce = function () {
	console.log(`My name is ${this.firstName} and I study ${this.course}`);
};

const mike = new Student("Mike", 2001, "Computer Science");
mike.introduce();
console.log(mike.calcAge());
console.log(mike);

console.log(
	mike instanceof Student,
	mike instanceof Person,
	mike instanceof Object,
);
