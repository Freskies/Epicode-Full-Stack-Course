"use strict";

const BOARD_SIZE = 90;
const CARD_SIZE = Math.ceil(BOARD_SIZE / 6);

const tombola_number = {
	number: undefined,
	extracted: false,
};

const board = {
	board: undefined,

	generateBoard: () =>
		Array.from({ length: BOARD_SIZE }, (_, i) => ({
			...tombola_number,
			number: i + 1,
		})),

	extract() {
		const extractNumber = () => {
			const unextractedCells = this.board.filter(({ extracted }) => !extracted);
			return unextractedCells.splice(
				Math.floor(Math.random() * unextractedCells.length - 1),
				1,
			)[0];
		};
		const extracted = extractNumber();
		if (!extracted) return undefined;
		extracted.extracted = true;
		return extracted;
	},

	init() {
		this.board = this.generateBoard();
	},
};

const card = {
	columns: Math.ceil(BOARD_SIZE / 10),
	card: undefined,

	generateCard() {
		const numbers = Array.from({ length: this.columns }, (_, i) =>
			Array.from(
				{
					length: i === this.columns - 1 ? (BOARD_SIZE - i * 10) % 11 : 10,
				},
				(_, j) => j + 1 + i * 10,
			),
		);
		// console.log(numbers);

		const weighedNumbers = Array.from(numbers, numberSet => ({
			weight: numberSet.length <= 3 ? numberSet.length : 3,
			numberSet,
		}));

		const randomNumbers = Array.from({ length: CARD_SIZE }, () => {
			const totalWeight = weighedNumbers.reduce(
				(acc, { weight }) => (acc += weight),
				0,
			);

			const randomWeight = Math.floor(Math.random() * totalWeight + 1);
			let counter = 0;

			for (let i = 0; i < weighedNumbers.length; i++) {
				for (const _ of Array(weighedNumbers[i].weight)) {
					counter++;
					if (randomWeight === counter) {
						weighedNumbers[weighedNumbers.indexOf(weighedNumbers[i])].weight--;
						const index = Math.floor(
							Math.random() * weighedNumbers[i].numberSet.length,
						);
						return weighedNumbers[i].numberSet.splice(index, 1)[0];
					}
				}
			}
		});

		console.log(weighedNumbers);

		this.card = Array.from({ length: this.columns }, _ => []);

		for (const randomNumber of randomNumbers) {
			const index = Number(String(randomNumber - 1).padStart(2, "0")[0]);
			this.card[index].push(randomNumber);
		}

		console.log(this.card);
	},

	init() {},
};

const tombolaWebApp = {
	htmlElements: {
		board: document.querySelector(".board-container"),
		reset: document.querySelector(".btn--reset"),
		extract: document.querySelector(".btn-extract"),
		extractBox: document.querySelector(".extract-number-box"),
		add: document.querySelector(".btn--add-card"),
	},

	logicBoard: board,
	board: new Map(),
	cards: new Array(),

	initBoard() {
		const createItem = ({ number: num }) => {
			const div = document.createElement("div");
			div.textContent = num;
			div.classList.add("number");
			return div;
		};

		this.logicBoard.board.forEach(num => {
			const item = createItem(num);
			this.htmlElements.board.appendChild(item);
			this.board.set(num, item);
		});
	},

	renderBoard() {
		for (const [cell, htmlCell] of this.board.entries()) {
			console.log(htmlCell);
			cell.extracted
				? htmlCell.classList.remove("number--extracted")
				: htmlCell.classList.add("number--extracted");
			console.log(htmlCell);
		}
	},

	resetListener(self) {
		self.reset();
	},

	extractListener(self) {
		const cell = self.logicBoard.extract();
		self.board.get(cell).classList.add("number--extracted");
	},

	reset() {
		for (const [_, cell] of this.board) cell.remove();
		this.start(true);
	},

	start(reset = false) {
		this.logicBoard.init();
		this.initBoard();
		if (!reset) {
			this.htmlElements.reset.addEventListener("click", () => {
				this.resetListener(this);
			});
			this.htmlElements.extract.addEventListener("click", () => {
				this.extractListener(this);
			});
		}
	},
};

tombolaWebApp.start();
card.generateCard();
