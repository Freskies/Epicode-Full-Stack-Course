import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import HomePage from "./components/HomePage";
import BookPage from "./components/BookPage";
import "./index.css";

function App() {
	const [selectedBook, setSelectedBook] = useState(null);
	const returnHome = () => setSelectedBook(null);

	if (selectedBook)
		return (
			<BookPage
				returnHome={returnHome}
				selectedBook={selectedBook}
				setSelectedBook={setSelectedBook}
			/>
		);
	return <HomePage setSelectedBook={setSelectedBook} />;
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
);
