import React from "react";
import ReactDOM from "react-dom/client";
import Button from "./component/Button";
import Image from "./component/Image";

function App() {
	return (
		<main style={{ display: "grid", placeContent: "center", height: "100vh" }}>
			<Button text="button" />
			<Image
				url="https://sketchok.com/images/articles/01-cartoons/005-gravity-falls/23/09.jpg"
				alt="Bill"
			/>
		</main>
	);
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
);
