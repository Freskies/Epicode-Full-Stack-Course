import React, { useState, useEffect } from "react";
import { STRIVE_STUDENT_KEY } from "../student-key";
import BookError from "./BookError";
import Comments from "./Comments";
import { useCallback } from "react";

function BookPage({ returnHome, selectedBook, setSelectedBook }) {
	const [loading, setLoading] = useState(false);
	const [comments, setComments] = useState(null);
	const [displayError, setDisplayError] = useState(false);

	const fetchComments = useCallback(() => {
		setLoading(true);
		fetch(
			`https://striveschool-api.herokuapp.com/api/comments/${selectedBook}`,
			{
				headers: { Authorization: STRIVE_STUDENT_KEY },
			},
		)
			.then(res => {
				if (!res.ok) throw new Error("Bho");
				return res.json();
			})
			.then(data => {
				setComments(data);
			})
			.catch(_ => setDisplayError(true))
			.finally(setLoading(false));
	}, [selectedBook]);

	const sendComment = e => {
		e.preventDefault();

		const comment = e.target.querySelector("textarea").value;
		const rate = e.target.querySelector(".star-rating").value;

		fetch(`https://striveschool-api.herokuapp.com/api/comments/`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				Authorization: STRIVE_STUDENT_KEY,
			},
			body: JSON.stringify({ comment, rate, elementId: selectedBook }),
		})
			.then(res => {
				if (!res.ok) throw new Error("POST failed");
				return res.json();
			})
			.then(_ => fetchComments());
	};

	useEffect(() => {
		fetchComments();
	}, [fetchComments]);

	return (
		<>
			<header>
				<nav className="book-page-navbar">
					<button onClick={returnHome}>⬅️</button>
				</nav>
			</header>
			<main className="book-main">
				{loading && <p>loading</p>}
				{displayError ? (
					<BookError />
				) : (
					<Comments
						comments={comments}
						selectedBook={selectedBook}
						setSelectedBook={setSelectedBook}
						sendComment={sendComment}
					/>
				)}
			</main>
			<footer></footer>
		</>
	);
}

export default BookPage;
