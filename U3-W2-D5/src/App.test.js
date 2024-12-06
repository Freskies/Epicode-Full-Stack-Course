import { render, screen } from "@testing-library/react";
import App from "./App";

/*
Test give me the same problem as before, something is wrong in the dependencies...
I'll write anyway but obviously I can't run it.
I swear will be ok even if I can't run it.
*/

test("renders MapPage", async () => {
	render(<App />);
	const mapElement = await screen.findByTestId("map-page");
	expect(mapElement).toBeInTheDocument();
});

test("renders LocationMarker", async () => {
	render(<App />);
	const markerElement = await screen.findByTestId("marker");
	expect(markerElement).toBeInTheDocument();
});

test("renders LocationMarker popup on click", async () => {
	render(<App />);
	const markerElement = await screen.findByTestId("marker");
	markerElement.click();
	const popupElement = await screen.findByTestId("marker-link-icon");
	expect(popupElement).toBeInTheDocument();
});
