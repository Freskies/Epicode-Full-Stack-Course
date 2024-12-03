import { useEffect, useState } from "react";
import { STRIVE_STUDENT_KEY } from "./../student-key";
import Loading from "./Loading";
import Comment from "./Comment";

function Comments({ selectedBook }) {
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(false);
	const [comments, setComments] = useState(null);

	useEffect(() => {
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

	const postComment = () => {};

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
			></textarea>
			<select name="rating" id="rating">
				{Array.from({ length: 5 }, (_, i) => (
					<option key={i} value={i + 1}>
						{"⭐".repeat(i + 1)}
					</option>
				))}
			</select>
			<button onClick={postComment}>Submit</button>
		</section>
	);
}

export default Comments;
