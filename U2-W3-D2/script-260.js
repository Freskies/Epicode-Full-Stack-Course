"use strict";

const lotteryPromise = new Promise(function (resolve, reject) {
	setTimeout(function () {
		if (Math.random() > 0.5) resolve("you win");
		else reject(new Error("You lost you money"));
	}, 2000);
});

// lotteryPromise
// 	.then(res => console.log(res))
// 	.catch(error => console.error(error));

const wait = seconds =>
	new Promise(resolve => setTimeout(resolve, seconds * 1000));

wait(2).then(() => console.log("I waited 2 seconds"));
