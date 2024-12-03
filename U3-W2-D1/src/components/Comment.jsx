function Comment({ comment: { author, comment, rate } }) {
	return (
		<article className="comment">
			<div className="author-rate-wrapper">
				<p className="author">{author}</p>
				<p className="rate">{rate}</p>
			</div>
			<p className="comment-text">{comment}</p>
		</article>
	);
}

export default Comment;
