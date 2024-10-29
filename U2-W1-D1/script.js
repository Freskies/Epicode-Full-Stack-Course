"use strict";

/////////////////////////////////////////////////
/////////////////////////////////////////////////
// BANKIST APP

// Data
const account1 = {
	owner: "Jonas Schmedtmann",
	movements: [200, 450, -400, 3000, -650, -130, 70, 1300],
	interestRate: 1.2, // %
	pin: 1111,
};

const account2 = {
	owner: "Jessica Davis",
	movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
	interestRate: 1.5,
	pin: 2222,
};

const account3 = {
	owner: "Steven Thomas Williams",
	movements: [200, -200, 340, -300, -20, 50, 400, -460],
	interestRate: 0.7,
	pin: 3333,
};

const account4 = {
	owner: "Sarah Smith",
	movements: [430, 1000, 700, 50, 90],
	interestRate: 1,
	pin: 4444,
};

const accounts = [account1, account2, account3, account4];

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
const btnTransfer = document.querySelector(".form__btn--transfer");
const btnLoan = document.querySelector(".form__btn--loan");
const btnClose = document.querySelector(".form__btn--close");
const btnSort = document.querySelector(".btn--sort");

const inputLoginUsername = document.querySelector(".login__input--user");
const inputLoginPin = document.querySelector(".login__input--pin");
const inputTransferTo = document.querySelector(".form__input--to");
const inputTransferAmount = document.querySelector(".form__input--amount");
const inputLoanAmount = document.querySelector(".form__input--loan-amount");
const inputCloseUsername = document.querySelector(".form__input--user");
const inputClosePin = document.querySelector(".form__input--pin");

// global variables
let currentAccount = undefined;

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
const displayMovements = movements => {
	containerMovements.innerHTML = "";

	movements.forEach((movement, i) => {
		const type = movement > 0 ? "deposit" : "withdrawal";
		const html = `
      <div class="movements__row">
        <div class="movements__type movements__type--${type}">${
			i + 1
		} ${type}</div>
        <div class="movements__value">${movement}€</div>
      </div>
    `;
		containerMovements.insertAdjacentHTML("afterbegin", html);
	});
};

// BALANCE
const calcBalance = movements =>
	movements.reduce((acc, movement) => (acc += movement), 0);

const displayBalance = balance => (labelBalance.textContent = `${balance} EUR`);

const updateBalance = user => {
	displayBalance(calcBalance(user.movements));
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

const displaySummary = (incoming, outcoming, interest) => {
	labelSumIn.textContent = `${incoming} €`;
	labelSumOut.textContent = `${outcoming} €`;
	labelSumInterest.textContent = `${interest} €`;
};

const updateSummary = ({ movements, interestRate }) => {
	displaySummary(
		calcIncomingSummary(movements),
		calcOutcomingSummary(movements),
		calcInterestSummary(movements, interestRate),
	);
};

// LOGIN

const login = account => {
	// display UI
	containerApp.style.opacity = 100;

	// display welcome message
	labelWelcome.textContent = `Welcome back, ${account.owner.split(" ")[0]}`;

	// display data from account
	displayMovements(account.movements);
	updateBalance(account);
	updateSummary(account);
};

loginForm.addEventListener("submit", e => {
	e.preventDefault();
	const inputUsername = inputLoginUsername.value;
	const inputPin = inputLoginPin.value;

	currentAccount = accounts.find(({ username }) => username === inputUsername);
	if (currentAccount?.pin === Number(inputPin)) login(currentAccount);

	// clear form
	inputLoginUsername.value = "";
	inputLoginPin.value = "";
	inputLoginPin.blur();
});
