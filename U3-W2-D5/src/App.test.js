import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders MapPage", async () => {
	render(<App />);
	const linkElement = await screen.findByTestId("map-page");
	expect(linkElement).toBeInTheDocument();
});
