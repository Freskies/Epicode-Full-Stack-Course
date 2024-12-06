import { MapContainer, TileLayer } from "react-leaflet";
import LocationMarker from "./LocationMarker";
import { OPEN_WEATHER_KEY } from "./../api-key";

function MapPage() {
	return (
		<MapContainer
			center={[41.9, 12.29]}
			zoom={13}
			scrollWheelZoom={false}
			data-testid="map-page"
		>
			<TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
			<TileLayer
				opacity={0.5}
				url={`https://tile.openweathermap.org/map/temp_new/{z}/{x}/{y}.png?appid=${OPEN_WEATHER_KEY}`}
			/>
			<LocationMarker />
		</MapContainer>
	);
}

export default MapPage;
