"use strict";

const now = new Date("2020-02-12");

const getMonthDays = now =>
	Array.from(
		{ length: new Date(now.getFullYear(), now.getMonth() + 1, 0).getDate() },
		(_, i) => i + 1,
	);

console.log(getMonthDays(now));

Array.from({ length: 5 }, (_, i) => i);
