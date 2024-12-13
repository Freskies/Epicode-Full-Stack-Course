import { useState } from "react";
import AppleMusicLogo from "./components/AppleMusicLogo";

function App() {
	const [activeSideBar, setActiveSideBar] = useState(false);

	return (
		<>
			<nav
				className="navbar"
				onClick={() => setActiveSideBar(!activeSideBar)}
			></nav>
			<aside className={`sidebar ${activeSideBar ? "active" : ""}`}>
				<AppleMusicLogo />
			</aside>
			<main className="main">main</main>
			<footer className="footer">footer</footer>
		</>
	);
}

export default App;
