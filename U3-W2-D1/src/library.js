import fantasy from "./books/fantasy.json";
import history from "./books/history.json";
import horror from "./books/horror.json";
import romance from "./books/romance.json";
import scifi from "./books/scifi.json";

export const library = [
	...fantasy,
	...history,
	...horror,
	...romance,
	...scifi,
].reduce(
	(acc, cur) =>
		!acc.some(book => book.asin === cur.asin) ? [...acc, cur] : acc,
	[],
);

export const normalizeTitle = title =>
	title.trim().toLowerCase().replace(/\s+/g, " ");

export const filterLibrary = title =>
	library.filter(({ title: bookTitle }) =>
		normalizeTitle(bookTitle).includes(normalizeTitle(title)),
	);
