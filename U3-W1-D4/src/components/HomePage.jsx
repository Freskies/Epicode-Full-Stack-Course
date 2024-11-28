import { useState } from "react";
import fantasy from "../books/fantasy.json";
import history from "../books/history.json";
import horror from "../books/horror.json";
import romance from "../books/romance.json";
import scifi from "../books/scifi.json";
import Navbar from "./Navbar";
import Books from "./Books";

const books = { fantasy, history, horror, romance, scifi };

const genres = Object.keys(books).reduce(
	(acc, genre) => ({ ...acc, [genre]: true }),
	{},
);

function HomePage({ setSelectedBook }) {
	// NAVBAR FILTER BY GENRE
	const [currentGenres, setCurrentGenres] = useState(genres);
	const toggleGenre = genre =>
		setCurrentGenres({ ...currentGenres, [genre]: !currentGenres[genre] });

	// NAVBAR SEARCH BY TITLE
	const [currentSearchText, setCurrentSearchText] = useState("");

	// FILTERED BOOKS
	const isValidTitle = title =>
		title.toLowerCase().includes(currentSearchText.trim().toLowerCase());
	const isValidGenre = genre => currentGenres[genre];
	const filteredBooks = Object.values(books)
		.flat()
		.filter(
			({ title, category }) => isValidTitle(title) && isValidGenre(category),
		)
		.reduce(
			(acc, book) =>
				acc.some(item => item.asin === book.asin) ? acc : [...acc, book],
			[],
		);

	return (
		<>
			<header>
				<Navbar
					currentGenres={currentGenres}
					toggleGenre={toggleGenre}
					currentSearchText={currentSearchText}
					setCurrentSearchText={setCurrentSearchText}
				/>
			</header>
			<main>
				<Books
					filteredBooks={filteredBooks}
					setSelectedBook={setSelectedBook}
				/>
			</main>
			<footer></footer>
		</>
	);
}

export default HomePage;
