class Card {
	static CARD_CONTAINER = document.querySelector(".products-container");
	#id;
	name;
	description;
	brand;
	imageUrl;
	price;

	constructor({ name, description, brand, imageUrl, price, _id }) {
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.price = price;
		this.#id = _id ?? "";
	}

	setId(id) {
		this.#id = id;
	}

	equals(id) {
		return this.#id === id;
	}

	#genereateCard() {
		return `
			<article class="card" data-id="${this.#id}">
				<img
					class="preview-image"
					src="${this.imageUrl}"
					alt="${this.name}"
					data-id="${this.#id}"
				/>
				<h2 class="title" data-id="${this.#id}">${this.name}</h2>
				<a class="modify-button" href="#" data-id="${this.#id}" data-modify="true">
					<svg data-modify="true" data-id="${
						this.#id
					}" xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960">
						<path
							data-id="${this.#id}" data-modify="true"
							d="M686-132 444-376q-20 8-40.5 12t-43.5 4q-100 0-170-70t-70-170q0-36 10-68.5t28-61.5l146 146 72-72-146-146q29-18 61.5-28t68.5-10q100 0 170 70t70 170q0 23-4 43.5T584-516l244 242q12 12 12 29t-12 29l-84 84q-12 12-29 12t-29-12Z"
						/>
					</svg>
				</a>
			</article>
		`;
	}

	renderCard() {
		Card.CARD_CONTAINER.innerHTML += this.#genereateCard();
		return this;
	}
}
