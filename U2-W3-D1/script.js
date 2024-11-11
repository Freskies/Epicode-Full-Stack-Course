"use strict";

// EXERCISE 1

class User {
	constructor(firstName, lastName, age, location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.location = location;
	}

	static compareAge(user1, user2) {
		const [{ firstName: older }, { firstName: younger }] = [user1, user2].sort(
			({ age: a }, { age: b }) => b - a,
		);
		console.log(`${older} is older than ${younger}`);
	}
}

const gabriele = new User("Gabriele", "Lucarelli", 25, "Canada");
const massimo = new User("Massimo", "Pizzicannella", 28, "Cucina");

User.compareAge(gabriele, massimo);

// EXERCISE 2

class Pet {
	constructor(petName, ownerName, species, breed) {
		this.petName = petName;
		this.ownerName = ownerName;
		this.species = species;
		this.breed = breed;
	}

	static sameOwner(pet1, pet2) {
		return pet1.ownerName === pet2.ownerName;
	}
}

const larry = new Pet("Larry", "Martino", "Dog", "A ne so");
const parry = new Pet("Parry", "Rachele", "Dog", "A ne so");
const terry = new Pet("Tarry", "Martino", "Dog", "A ne so");

console.log(Pet.sameOwner(larry, parry));
console.log(Pet.sameOwner(larry, terry));
