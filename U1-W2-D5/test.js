/* TEST.JS
 * i will be using this file to test all exercises from D5.js
 */

"use strict";

const showExcerciseNumber = function (exerciseIndex) {
	console.log(`
		---- ESERCIZIO ${exerciseIndex} ----
		`);
};

/***********************************/
/* ESERCIZIO 1 */
/***********************************/

showExcerciseNumber(1);

logArray(pets);

/***********************************/
/* ESERCIZIO 2 */
/***********************************/

showExcerciseNumber(2);

console.log(sortedAlphabetically(pets));

/***********************************/
/* ESERCIZIO 3 */
/***********************************/

showExcerciseNumber(3);

logReversedArray(pets);

/***********************************/
/* ESERCIZIO 4 */
/***********************************/

showExcerciseNumber(4);

console.log(firstBecomeLast(pets));

/***********************************/
/* ESERCIZIO 5 and 6 */
/***********************************/

showExcerciseNumber(6);

console.log(cars);

/***********************************/
/* ESERCIZIO 7 */
/***********************************/

showExcerciseNumber(7);

console.log(justTrims);

/***********************************/
/* ESERCIZIO 8 */
/***********************************/

showExcerciseNumber(8);

fizzOrBuzz(cars);

/***********************************/
/* ESERCIZIO 9 */
/***********************************/

showExcerciseNumber(9);

console.log("EXCLUDED:");
until32Excluded(numericArray);
console.log("INCLUDED:");
until32Included(numericArray);
