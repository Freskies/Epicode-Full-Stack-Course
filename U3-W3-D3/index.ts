function es1(): void {
	console.log("number, string, undefined, null, boolean, bigInt, symbol, any");
}

function es2(): void {
	const myName: string = "Valerio";
	const myAge: number = 21;
	const iAmStudyngTypescript: boolean = true;
}

function es3(): void {
	const greet = (personName: string): string => "Ciao " + personName;
}

function es4(): void {
	const sum = (a: number, b: number): number => a + b;
	console.log(sum(10, 15));
}

function es5(): void {
	const applyIVA = (price: number): number => price * 1.22;
	console.log(applyIVA(10));
}

function es6(): void {
	const sumLength = (...strings: string[]): number =>
		strings.reduce((acc, cur) => acc + cur.length, 0);
	console.log(sumLength("ciao", "culo"));
}

function es7(): void {
	console.log(
		"|: is used to be able to declare multiple possible type for a variable",
	);
}

function es8(): void {
	const myVar: number | null | undefined = 5;
}

function es9(): void {
	enum Days {
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday,
	}
	const getDay = (day: Days) => Days[day];
	const day: Days = Days.Monday;
	console.log(getDay(day));
}

function es10(): void {
	const numbers1: number[] = [1, 2, 3];
	const numbers2: Array<number> = [1, 2, 3];
}

function es11(): void {
	type myTuple = [string, string, string, number, number];
	const person: myTuple = ["a", "b", "c", 1, 2];
	console.log(person);
}

function es12(): void {
	console.log("your mother");
}

function es13(): void {
	interface Person {
		firstname: string;
		lastname: string;
		age: number;
	}
	const valerio: Person = {
		firstname: "Valerio",
		lastname: "Giacchini",
		age: 21,
	};
	console.log(valerio);
}

function es14(): void {
	interface User {
		email: string;
		phone?: string;
	}
	const valerio: User = {
		email: "freskies.bico.apo@gmail.com",
	};
	console.log(valerio);
}

function es15(): void {
	type Student = {
		studentName: string;
		grade: number;
	};
	const valerio: Student = {
		studentName: "Valerio",
		grade: 11,
	};
	const arr: Array<Student> = [valerio];
}

function es16_17(): void {
	interface Vehicle {
		make: string;
		model: string;
		year: number;
	}

	interface Car extends Vehicle {
		color: string;
	}

	const myCar: Car = {
		make: "Toyota",
		model: "Corolla",
		year: 2020,
		color: "red",
	};

	console.log(myCar);
}

function es18(): void {
	console.log("your sister!");
}

function es19(): void {
	console.log("yes");
}
