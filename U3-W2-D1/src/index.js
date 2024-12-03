// REACT
import React, { useState } from "react";
import ReactDOM from "react-dom/client";

// BOOKS
import { filterLibrary } from "./library";

// COMPONENTS
import Navbar from "./components/Navbar";
import Books from "./components/Books";
import Comments from "./components/Comments";
import Footer from "./components/Footer";

// CSS
import "./index.css";

function App() {
	const [search, setSearch] = useState("");
	const [selectedBook, setSelectedBook] = useState(null);

	const filterdLibrary = filterLibrary(search);
	console.log(selectedBook);

	return (
		<>
			<header>
				<Navbar search={search} setSearch={setSearch} />
			</header>
			<main>
				<Books library={filterdLibrary} setSelectedBook={setSelectedBook} />
				<Comments selectedBook={selectedBook} />
			</main>
			<Footer />
		</>
	);
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
);
