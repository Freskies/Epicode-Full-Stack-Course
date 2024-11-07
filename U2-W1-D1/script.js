"use strict";

const FAKE_LOGIN = false;
const LOG_OUT_TIMER_SECONDS = 10 * 60;
// const LOG_OUT_TIMER_SECONDS = 10;

// USEFUL FUNCTIONS

const getDateInfo = date => {
	return {
		day: `${date.getDate()}`.padStart(2, 0),
		month: `${date.getMonth() + 1}`.padStart(2, 0),
		year: date.getFullYear(),
		hour: `${date.getHours()}`.padStart(2, 0),
		minute: `${date.getMinutes()}`.padStart(2, 0),
	};
};

const daysPassed = (date1, date2) =>
	Math.round(Math.abs(date2 - date1) / (1000 * 60 * 60 * 24));

const formatDate = (date, locale) => {
	const days = daysPassed(date, new Date());
	switch (true) {
		case days === 0:
			return "Today";
		case days === 1:
			return "Yesterday";
		case days > 7:
			// const { year, month, day } = getDateInfo(date);
			// return `${day}/${month}/${year}`;
			const options = {
				day: "numeric",
				month: "numeric",
				year: "numeric",
			};
			return new Intl.DateTimeFormat(locale, options).format(date);
		default:
			return `${days} days ago`;
	}
};

const formatCurrency = (value, locale, currency) =>
	new Intl.NumberFormat(locale, {
		style: "currency",
		currency,
	}).format(value);

const formatTimer = seconds => {
	const mm = String(Math.trunc(seconds / 60)).padStart(2, 0);
	const ss = String(seconds % 60).padStart(2, 0);
	return `${mm}:${ss}`;
};

/////////////////////////////////////////////////
/////////////////////////////////////////////////
// BANKIST APP

const account1 = {
	owner: "Jonas Schmedtmann",
	movements: [200, 455.23, -306.5, 25000, -642.21, -133.9, 79.97, 1300],
	interestRate: 1.2, // %
	pin: 1111,

	movementsDates: [
		"2019-11-18T21:31:17.178Z",
		"2019-12-23T07:42:02.383Z",
		"2020-01-28T09:15:04.904Z",
		"2020-04-01T10:17:24.185Z",
		"2020-05-08T14:11:59.604Z",
		"2020-05-27T17:01:17.194Z",
		"2020-07-11T23:36:17.929Z",
		"2020-07-12T10:51:36.790Z",
	],
	currency: "EUR",
	locale: "pt-PT", // de-DE
};

const account2 = {
	owner: "Jessica Davis",
	movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
	interestRate: 1.5,
	pin: 2222,

	movementsDates: [
		"2019-11-01T13:15:33.035Z",
		"2019-11-30T09:48:16.867Z",
		"2019-12-25T06:04:23.907Z",
		"2020-01-25T14:18:46.235Z",
		"2020-02-05T16:33:06.386Z",
		"2020-04-10T14:43:26.374Z",
		"2020-06-25T18:49:59.371Z",
		"2020-07-26T12:01:20.894Z",
	],
	currency: "USD",
	locale: "en-US",
};

const accounts = [account1, account2];

// Elements
const labelWelcome = document.querySelector(".welcome");
const labelDate = document.querySelector(".date");
const labelBalance = document.querySelector(".balance__value");
const labelSumIn = document.querySelector(".summary__value--in");
const labelSumOut = document.querySelector(".summary__value--out");
const labelSumInterest = document.querySelector(".summary__value--interest");
const labelTimer = document.querySelector(".timer");

const containerApp = document.querySelector(".app");
const containerMovements = document.querySelector(".movements");

const loginForm = document.querySelector(".login");
const btnLogin = document.querySelector(".login__btn");
const transferForm = document.querySelector(".form--transfer");
const btnTransfer = document.querySelector(".form__btn--transfer");
const btnLoan = document.querySelector(".form__btn--loan");
const loanForm = document.querySelector(".form--loan");
const btnClose = document.querySelector(".form__btn--close");
const closeForm = document.querySelector(".form--close");
const btnSort = document.querySelector(".btn--sort");

const inputLoginUsername = document.querySelector(".login__input--user");
const inputLoginPin = document.querySelector(".login__input--pin");
const inputTransferTo = document.querySelector(".form__input--to");
const inputTransferAmount = document.querySelector(".form__input--amount");
const inputLoanAmount = document.querySelector(".form__input--loan-amount");
const inputCloseUsername = document.querySelector(".form__input--user");
const inputClosePin = document.querySelector(".form__input--pin");

labelTimer.setAttribute("data-timer", formatTimer(LOG_OUT_TIMER_SECONDS));

// global variables
let currentAccount = undefined;
let sortMovements = false;

// USER
const createUsernames = users => {
	const createUsername = user =>
		user
			.split(" ")
			.map(partName => partName[0])
			.join("")
			.toLowerCase();

	users.forEach(user => (user.username = createUsername(user.owner)));
};

createUsernames(accounts);

// MOVEMENTS
const displayMovements = (
	{ movements, movementsDates, locale, currency },
	sort = sortMovements,
) => {
	containerMovements.innerHTML = "";
	const movementsToDisplay = sort
		? movements.slice().sort((a, b) => a - b)
		: movements;

	movementsToDisplay.forEach((movement, i) => {
		const type = movement > 0 ? "deposit" : "withdrawal";
		const displayDate = formatDate(new Date(movementsDates[i]), locale);
		const formattedMovement = formatCurrency(movement, locale, currency);

		const html = `
      <div class="movements__row">
        <div class="movements__type movements__type--${type}">${
			i + 1
		} ${type}</div>
				<div class="movements_date">${displayDate}</div>
        <div class="movements__value">${formattedMovement}</div>
      </div>
    `;
		containerMovements.insertAdjacentHTML("afterbegin", html);
	});
	/*
	const movementUI = Array.from(
		document.querySelectorAll(".movements__value"),
		el => parseInt(el.textContent),
	).reduce((acc, movement) => acc + movement, 0);
	console.log(movementUI);
	*/
};

// BALANCE

const calcBalance = movements =>
	movements.reduce((acc, movement) => (acc += movement), 0);

const displayBalance = (balance, locale, currency) =>
	(labelBalance.textContent = formatCurrency(balance, locale, currency));

const updateBalance = ({ balance, movements, locale, currency }) => {
	balance = calcBalance(movements);
	displayBalance(balance, locale, currency);
};

const calcIncomingSummary = movements =>
	movements
		.filter(movement => movement > 0)
		.reduce((acc, movement) => acc + movement, 0);

const calcOutcomingSummary = movements =>
	movements
		.filter(movement => movement < 0)
		.reduce((acc, movement) => acc + movement, 0);

const calcInterestSummary = (movements, intrestRate) =>
	movements
		.filter(movement => movement > 0)
		.map(deposit => (deposit * intrestRate) / 100)
		.filter(interest => interest >= 1)
		.reduce((acc, interest) => acc + interest, 0);

const displaySummary = (incoming, outcoming, interest, locale, currency) => {
	labelSumIn.textContent = formatCurrency(incoming, locale, currency);
	labelSumOut.textContent = formatCurrency(outcoming, locale, currency);
	labelSumInterest.textContent = formatCurrency(interest, locale, currency);
};

const updateSummary = ({ movements, interestRate, locale, currency }) => {
	displaySummary(
		calcIncomingSummary(movements),
		calcOutcomingSummary(movements),
		calcInterestSummary(movements, interestRate),
		locale,
		currency,
	);
};

const updateUI = account => {
	displayMovements(account);
	updateBalance(account);
	updateSummary(account);
};

// LOGIN

let currentTimer;

const searchAccount = (username, pin) => {
	const account = accounts.find(({ username: uName }) => uName === username);
	return account?.pin === Number(pin) ? account : undefined;
};

const logout = () => {
	containerApp.style.opacity = 0;
};

const startLogOutTimer = () => {
	let seconds = LOG_OUT_TIMER_SECONDS;

	const tick = () => {
		labelTimer.setAttribute("data-timer", formatTimer(seconds));
		if (seconds === 0) {
			clearInterval(logoutTimer);
			logout();
		}
		seconds--;
	};

	tick();
	const logoutTimer = setInterval(tick, 1000);
	return logoutTimer;
};

const resetLogOutTimer = () => {
	clearInterval(currentTimer);
	currentTimer = startLogOutTimer();
};

const login = account => {
	// clear timer
	if (currentTimer) clearInterval(currentTimer);

	// display UI
	containerApp.style.opacity = 100;

	// display welcome message
	labelWelcome.textContent = `Welcome back, ${account.owner.split(" ")[0]}`;

	// display date
	const options = {
		hour: "numeric",
		minute: "numeric",
		day: "numeric",
		month: "numeric",
		year: "numeric",
		// weekday: "long", // short / narrow
	};
	// const locale = navigator.language;
	labelDate.textContent = new Intl.DateTimeFormat(
		account.locale,
		options,
	).format(new Date());

	// display data from account
	updateUI(account);

	currentTimer = startLogOutTimer();
};

// EVENT HANDLERS

loginForm.addEventListener("submit", e => {
	e.preventDefault();
	const inputUsername = inputLoginUsername.value;
	const inputPin = inputLoginPin.value;

	currentAccount = searchAccount(inputUsername, inputPin);
	if (currentAccount) login(currentAccount);

	// clear form
	inputLoginUsername.value = "";
	inputLoginPin.value = "";
	inputLoginPin.blur();
});

transferForm.addEventListener("submit", e => {
	resetLogOutTimer();
	e.preventDefault();

	// get data from form
	const amount = Number(inputTransferAmount.value);
	const receiverAccount = accounts.find(
		({ username }) => username === inputTransferTo.value,
	);

	// clear form
	inputTransferAmount.value = "";
	inputTransferTo.value = "";

	// the account to transfer must exist
	if (!receiverAccount) return;
	// the account must be not myself
	if (receiverAccount === currentAccount) return;
	// amount must be > 0
	if (amount <= 0) return;
	// you must have enough money
	if (currentAccount.balance < amount) return;

	// movement
	currentAccount.movements.push(-amount);
	receiverAccount.movements.push(amount);

	// movement date
	currentAccount.movementsDates.push(new Date().toISOString());
	receiverAccount.movementsDates.push(new Date().toISOString());

	updateUI(currentAccount);
});

closeForm.addEventListener("submit", e => {
	resetLogOutTimer();
	e.preventDefault();

	const useranme = inputCloseUsername.value;
	const pin = inputClosePin.value;

	const account = searchAccount(useranme, pin);

	if (account === currentAccount) {
		// delete account
		accounts.splice(
			accounts.findIndex(({ username }) => username === account.username),
			1,
		);
		// hide UI (log out)
		containerApp.style.opacity = 0;
	}
});

loanForm.addEventListener("submit", e => {
	resetLogOutTimer();
	e.preventDefault();

	const amount = Math.floor(inputLoanAmount.value);

	// clear form
	inputLoanAmount.value = "";

	// amount must be grather than 0
	if (amount < 0) return;

	// amount must me at maximum 10 times bigger than your bigger deposit
	if (currentAccount.movements.some(movement => movement >= amount * 0.1))
		setTimeout(() => {
			currentAccount.movements.push(amount);
			currentAccount.movementsDates.push(new Date().toISOString());
			updateUI(currentAccount);
		}, 2500);
});

btnSort.addEventListener("click", e => {
	resetLogOutTimer();
	e.preventDefault();
	sortMovements = !sortMovements;
	displayMovements(currentAccount);
});

// OVERAL BALANCE

/* old way
const overalBalance = accounts
	.map(({ movements }) => movements)
	.flat()
	.reduce((acc, movement) => acc + movement, 0);
*/

const overalBalance = accounts =>
	accounts
		.flatMap(({ movements }) => movements)
		.reduce((acc, movement) => acc + movement, 0);

const overalDeposit = accounts =>
	accounts
		.flatMap(({ movements }) => movements)
		.reduce((acc, movement) => (movement > 0 ? acc + movement : acc), 0);

if (FAKE_LOGIN) {
	currentAccount = account1;
	login(currentAccount);
}
