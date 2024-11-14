class Book {
	#asin;
	#img;
	#price;
	#title;
	static LIBRARY_CONTAINER = document.querySelector(".library");

	constructor({ asin, img, price, title }) {
		this.#asin = asin;
		this.#img = img;
		this.#price = price;
		this.#title = title;
	}

	#createBookCard() {
		const card = document.createElement("div");
		card.classList.add("card");
		card.innerHTML = `
			<img src="${this.#img}" class="card-img-top" alt="${this.#title}">
			<div class="card-body">
				<h5 class="card-title">${this.#title}</h5>
				<div class="buy-wrapper">
					<p class="price">${this.#price} $</p>
					<button href="#" class="btn-buy" data-asin="${this.#asin}">Buy</button>
				</div>
			</div>
		`;
		return card;
	}

	equal(asin) {
		return this.#asin === asin;
	}

	render() {
		Book.LIBRARY_CONTAINER.insertAdjacentElement(
			"beforeend",
			this.#createBookCard(),
		);
	}
}
