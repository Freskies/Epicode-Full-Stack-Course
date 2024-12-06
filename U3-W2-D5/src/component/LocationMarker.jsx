import { useEffect, useState, useCallback } from "react";
import { Marker, Popup, useMapEvents } from "react-leaflet";

function LocationMarker() {
	const [position, setPosition] = useState(null);
	const map = useMapEvents({
		click(e) {
			setPosition(e.latlng);
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
			<Popup>You are here</Popup>
		</Marker>
	);
}

export default LocationMarker;
