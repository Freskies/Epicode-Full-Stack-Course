import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Home from "./Home";
import Profile from "./Profile";
import Settings from "./Settings";
import profile from "./assets/profile.json";

function App() {
	// PAGE FLOW
	const [displayPage, setDisplayPage] = useState("Home");
	const displayHome = () => setDisplayPage("Home");
	const displayProfile = () => setDisplayPage("Profile");
	const displaySettings = () => setDisplayPage("Settings");

	// SERIES TO RENDER
	const [series, setSeries] = useState([
		"The Mentalist",
		"Breaking Bad",
		"Harry Potter",
	]);

	const changeSeries = (title, newTitle) =>
		setSeries(
			[...series].map(itemTitle =>
				itemTitle === title ? newTitle : itemTitle,
			),
		);
	const addSeries = title => setSeries([...series, title]);
	const removeSeries = title =>
		setSeries(series.filter(itemTitle => itemTitle !== title));

	switch (displayPage) {
		case "Home":
			return (
				<Home
					profile={profile}
					displayProfile={displayProfile}
					displaySettings={displaySettings}
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
