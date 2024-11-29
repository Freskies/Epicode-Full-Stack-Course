import { useState, useEffect } from "react";
import Carousel from "./Carousel";
import Loading from "./Loading";

function Series({ title, IDBD_API_KEY }) {
	const [episodes, setEpisodes] = useState([]);
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		setLoading(true);
		fetch(`http://www.omdbapi.com/?apikey=${IDBD_API_KEY}&s=${title}`)
			.then(response => response.json())
			.then(data => {
				if (!data.Search?.length) return;
				setEpisodes(data.Search.filter(({ Poster }) => Poster !== "N/A"));
			})
			.catch(error => console.error(error))
			.finally(() => setLoading(false));
	}, [IDBD_API_KEY, title]);

	return (
		<article className="home-series">
			<h2>{title}</h2>
			{loading ? (
				<Loading />
			) : (
				<Carousel episodes={episodes} loading={loading} />
			)}
		</article>
	);
}

export default Series;
