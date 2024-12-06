import { BrowserRouter, Routes, Route } from "react-router-dom";
import MapPage from "./component/MapPage";
import Details from "./component/Details";

function App() {
	return (
		<BrowserRouter>
			<header></header>
			<main>
				<Routes>
					<Route path="/" element={<MapPage />} />
					<Route path="/details/:coords" element={<Details />} />
				</Routes>
			</main>
			<footer></footer>
		</BrowserRouter>
	);
}

export default App;
