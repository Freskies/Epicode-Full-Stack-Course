function SingleAlbum({ album: { cover, firstCaption, secondCaption } }) {
	return (
		<figure className="album">
			<img src={cover} alt={firstCaption} />
			<figcaption>
				<p className="first-caption">{firstCaption}</p>
				<p className="second-caption">{secondCaption}</p>
			</figcaption>
		</figure>
	);
}

export default SingleAlbum;
