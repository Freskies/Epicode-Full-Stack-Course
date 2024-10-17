"use strict";

const BOARD_SIZE = 90;

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
			console.log("first");
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
