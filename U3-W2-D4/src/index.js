import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Home from "./Home";
import Profile from "./Profile";
import Settings from "./Settings";
import profile from "./assets/profile.json";
import { IDBD_API_KEY } from "./imdbKey";
import { BrowserRouter, Routes, Route } from "react-router";

function normalizeTitle(title) {
	return Array.from(
		title.toLowerCase().trim().replace(/\s+/g, " ").split(" "),
		word => word[0].toUpperCase() + word.slice(1),
	).join(" ");
}

export function App() {
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

	const homePage = (
		<Home profile={profile} series={series} IDBD_API_KEY={IDBD_API_KEY} />
	);

	const profilePage = <Profile profile={profile} />;

	const settingsPage = (
		<Settings
			series={series}
			changeSeries={changeSeries}
			addSeries={addSeries}
			removeSeries={removeSeries}
		/>
	);

	return (
		<BrowserRouter>
			<Routes>
				<Route index element={homePage} />
				<Route path="profile" element={profilePage} />
				<Route path="settings" element={settingsPage} />
			</Routes>
		</BrowserRouter>
	);
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
);
