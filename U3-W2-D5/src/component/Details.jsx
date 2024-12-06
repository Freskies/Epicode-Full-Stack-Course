import { useState, useEffect, useCallback } from "react";
import { useParams } from "react-router-dom";
import { OPEN_WEATHER_KEY } from "./../api-key";
import ForecastPage from "./ForecastPage";
import { Link } from "react-router-dom";
import Loading from "./Loading";

function Details() {
	const [position, setPosition] = useState(null);
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(false);
	const [forecast, setForecast] = useState(null);

	const [lat, lng] = Array.from(useParams().coords.split("-"), coord =>
		Number.parseFloat(coord),
	);

	useEffect(() => {
		setPosition({ lat, lng });
	}, [lat, lng]);

	const getWeather = useCallback(() => {
		if (!position) {
			setError(true);
			return;
		}
		setLoading(true);
		setError(false);
		const { lat, lng } = position;
		fetch(
			`https://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lng}&appid=${OPEN_WEATHER_KEY}&mode=json&units=metric&lang=en`,
		)
			.then(res => {
				if (res.ok) return res.json();
				else throw new Error("Error in fetch weather");
			})
			.then(data => setForecast(data.list))
			.catch(err => {
				setError(true);
				console.error(err);
			})
			.finally(() => setLoading(false));
	}, [position]);

	useEffect(getWeather, [getWeather]);

	return (
		<div className="forecast-page">
			<nav className="details-navbar">
				<Link to="/" className="back">
					<i className="fa fa-arrow-left"></i>
					<span>Back</span>
				</Link>
			</nav>
			{loading && <Loading />}
			{error && <h1>Error</h1>}
			{forecast && <ForecastPage forecast={forecast} />}
		</div>
	);
}

export default Details;
