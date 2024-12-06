import { useState, useEffect } from "react";
import { MapContainer, TileLayer } from "react-leaflet";
import LocationMarker from "./component/LocationMarker";

function App() {
	const [locate, setLocate] = useState(null);

	return (
		<>
			<header></header>
			<main>
				<MapContainer center={[41.9, 12.29]} zoom={13} scrollWheelZoom={false}>
					<TileLayer
						attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
						url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
					/>
					<LocationMarker onLocate={setLocate} />
				</MapContainer>
			</main>
			<footer></footer>
		</>
	);
}

export default App;
