"use strict";

console.log("Hello, world!");
setTimeout(() => console.log("0 sec timer"), 0);
Promise.resolve("Resolved promise 1").then(res => console.log(res));
Promise.resolve("Resolved promise 2").then(res => {
	for (let i = 0; i < 1_000_000_000; i++) {}
	console.log(res);
});
console.log("Test End");
