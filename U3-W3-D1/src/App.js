import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import MainSearch from "./components/MainSearch";
import CompanySearchResults from "./components/CompanySearchResults";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import FavouritePage from "./components/FavouritePage";

function App() {
	return (
		<BrowserRouter>
			<Routes>
				<Route path="/" element={<MainSearch />} />
				<Route path="/favourites" element={<FavouritePage />} />
				<Route path="/:company" element={<CompanySearchResults />} />
			</Routes>
		</BrowserRouter>
	);
}

export default App;
