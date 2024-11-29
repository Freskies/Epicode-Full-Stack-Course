import { useState, useEffect } from "react";
import Carousel from "./Carousel";
import Loading from "./Loading";

function Series({ title, IDBD_API_KEY }) {
	const [episodes, setEpisodes] = useState([]);
	const [loading, setLoading] = useState(true);
	const [error, setError] = useState(false);

	useEffect(() => {
		setLoading(true);
		setError(false);
		fetch(`http://www.omdbapi.com/?apikey=${IDBD_API_KEY}&s=${title}`)
			.then(response => response.json())
			.then(data => {
				if (!data.Search?.length) {
					setError(true);
					return;
				}
				setEpisodes(data.Search.filter(({ Poster }) => Poster !== "N/A"));
			})
			.catch(_ => setError(true))
			.finally(() => setLoading(false));
	}, [IDBD_API_KEY, title]);

	return (
		<article className="home-series">
			<h2 className={"" + (error && "error")}>{title}</h2>
			{loading ? (
				<Loading />
			) : (
				!error && <Carousel episodes={episodes} loading={loading} />
			)}
		</article>
	);
}

export default Series;
