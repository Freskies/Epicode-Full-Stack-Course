import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import fantasy from "./books/fantasy.json";
import history from "./books/history.json";
import horror from "./books/horror.json";
import romance from "./books/romance.json";
import scifi from "./books/scifi.json";
import "./index.css";
import Navbar from "./components/navbar";
import Books from "./components/books";

function App() {
	const books = { fantasy, history, horror, romance, scifi };
	const bookGenres = Object.keys(books);

	const [genre, setGenre] = useState(bookGenres[1]);
	const [searchText, setSearchText] = useState("");

	return (
		<>
			<header>
				<Navbar
					genre={genre}
					setGenre={setGenre}
					searchText={searchText}
					setSearchText={setSearchText}
					bookGenres={bookGenres}
				/>
			</header>
			<main>
				<Books books={books[genre]} searchText={searchText} />
			</main>
			<footer></footer>
		</>
	);
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
);
