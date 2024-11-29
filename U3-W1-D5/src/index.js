import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Home from "./Home";
import Profile from "./Profile";
import Settings from "./Settings";
import profile from "./assets/profile.json";
import { IDBD_API_KEY } from "./imdbKey";

function normalizeTitle(title) {
	return Array.from(
		title.toLowerCase().trim().replace(/\s+/g, " ").split(" "),
		word => word[0].toUpperCase() + word.slice(1),
	).join(" ");
}

function App() {
	// PAGE FLOW
	const [displayPage, setDisplayPage] = useState("Home");
	const displayHome = () => setDisplayPage("Home");
	const displayProfile = () => setDisplayPage("Profile");
	const displaySettings = () => setDisplayPage("Settings");

	// SERIES TO RENDER
	const [series, setSeries] = useState([
		"Lord Of The Rings",
		"Breaking Bad",
		"Harry Potter",
	]);
	const changeSeries = (title, newTitle) =>
		setSeries(
			[...series].map(itemTitle =>
				itemTitle === title ? normalizeTitle(newTitle) : itemTitle,
			),
		);
	const addSeries = title => setSeries([...series, title]);
	const removeSeries = title =>
		setSeries(series.filter(itemTitle => itemTitle !== title));

	// RENDER PAGE
	switch (displayPage) {
		case "Home":
			return (
				<Home
					profile={profile}
					displayProfile={displayProfile}
					displaySettings={displaySettings}
					series={series}
					IDBD_API_KEY={IDBD_API_KEY}
				/>
			);
		case "Profile":
			return <Profile displayHome={displayHome} profile={profile} />;
		case "Settings":
			return (
				<Settings
					displayHome={displayHome}
					series={series}
					changeSeries={changeSeries}
					addSeries={addSeries}
					removeSeries={removeSeries}
				/>
			);
		default:
			throw new Error("No page found");
	}
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
);
