function Comments({ comments, selectedBook, sendComment }) {
	return (
		<div className="comments">
			{comments?.map(({ _id, comment, rate, author }) => (
				<div key={_id} className="comment">
					<p className="author">{author}</p>
					<div className="comment-body">
						<p className="comment-text">{comment}</p>
						<p className="rating">{rate}</p>
					</div>
				</div>
			))}
			<form className="write-comment" onSubmit={e => sendComment(e)}>
				<textarea type="text" placeholder="Write a comment..." />
				<input
					className="star-rating"
					type="number"
					placeholder="Rate"
					step={1}
					min={1}
					max={5}
				/>
				<button>Send</button>
			</form>
		</div>
	);
}

export default Comments;
