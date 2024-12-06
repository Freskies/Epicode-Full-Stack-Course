import { useEffect, useState, useCallback } from "react";
import { Marker, Popup, useMapEvents } from "react-leaflet";
import { OPEN_WEATHER_KEY } from "./../api-key";
import { Link } from "react-router-dom";

function LocationMarker() {
	const [position, setPosition] = useState(null);
	const [markerInfo, setMarkerInfo] = useState("");

	// WEATHER
	const getWeather = useCallback(() => {
		if (!position) return;
		const { lat, lng } = position;
		fetch(
			`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${OPEN_WEATHER_KEY}`,
		)
			.then(res => {
				if (res.ok) return res.json();
				else throw new Error("Error in fetch weather");
			})
			.then(data => setMarkerInfo(data.name))
			.catch(err => console.log(err));
	}, [position]);

	useEffect(getWeather);

	// MAP
	const map = useMapEvents({
		click({ latlng }) {
			setPosition(latlng);
		},
		locationfound(e) {
			setPosition(e.latlng);
			map.flyTo(e.latlng, map.getZoom());
		},
	});

	const locate = useCallback(map => map.locate(), []);

	useEffect(() => {
		locate(map);
	}, [map, locate]);

	return position === null ? null : (
		<Marker position={position}>
			<Popup>
				<Link
					className="weather-info-popup"
					to={`/details/${position.lat}-${position.lng}`}
				>
					{markerInfo || "See Weather"}{" "}
					<i className="fa fa-external-link-alt"></i>
				</Link>
			</Popup>
		</Marker>
	);
}

export default LocationMarker;
