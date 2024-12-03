import { useCallback, useEffect, useState } from "react";
import { STRIVE_STUDENT_KEY } from "./../student-key";
import Loading from "./Loading";
import Comment from "./Comment";

function Comments({ selectedBook }) {
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(false);
	const [comments, setComments] = useState(null);
	const [comment, setComment] = useState("");
	const [rating, setRating] = useState(0);

	const handleStarClick = e => setRating(Number(e.target.dataset?.star) || 0);

	useEffect(() => setRating(0), [selectedBook]);

	const fetchComments = useCallback(() => {
		if (!selectedBook) return;
		setLoading(true);
		fetch(
			`https://striveschool-api.herokuapp.com/api/comments/${selectedBook}`,
			{
				headers: { Authorization: STRIVE_STUDENT_KEY },
			},
		)
			.then(res => {
				if (res.ok) return res.json();
				throw new Error("Promise not resolved");
			})
			.then(data => setComments(data))
			.catch(_ => setError(true))
			.finally(_ => setLoading(false));
	}, [selectedBook]);

	useEffect(fetchComments, [fetchComments]);

	const postComment = e => {
		e.preventDefault();

		if (!selectedBook) return;
		if (!rating) return alert("Please select a rating");

		fetch(`https://striveschool-api.herokuapp.com/api/comments/`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				Authorization: STRIVE_STUDENT_KEY,
			},
			body: JSON.stringify({ comment, rate: rating, elementId: selectedBook }),
		})
			.then(res => {
				if (res.ok) return res.json();
				else throw new Error("Something went wrong");
			})
			.then(_ => {
				fetchComments();
				setRating(0);
				setComment("");
			})
			.catch(_ => {
				alert("Something went wrong");
			});
	};

	if (!selectedBook || error)
		return <section className="comments comments--empty"></section>;

	return (
		<section className="comments">
			<h2>Comments:</h2>
			{loading ? (
				<Loading />
			) : (
				comments?.map(comment => (
					<Comment key={comment._id} comment={comment} />
				))
			)}
			<h3>Write something:</h3>
			<textarea
				name="comment"
				id="comment"
				cols="30"
				rows="10"
				placeholder="Write your comment here..."
				value={comment}
				onChange={e => setComment(e.target.value)}
			></textarea>
			<div
				className="rating"
				name="rating"
				id="rating"
				onClick={handleStarClick}
			>
				{Array.from({ length: 5 }, (_, i) => {
					const star = 5 - i;
					return (
						<i
							key={i}
							data-star={star}
							className={`fas fa-star rating__star ${
								star === rating && "rating__star--selected"
							}`}
						></i>
					);
				})}
			</div>
			<button className="submit-btn" onClick={postComment}>
				Submit
			</button>
		</section>
	);
}

export default Comments;
