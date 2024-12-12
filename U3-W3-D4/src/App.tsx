import { useEffect, useState } from "react";
import { Articles, Result } from "./interfaces";

function App() {
	const [data, setData] = useState<Result[] | null>(null);

	useEffect(() => {
		(async () => {
			const res: Response = await fetch(
				"https://api.spaceflightnewsapi.net/v4/articles",
			);
			const articles: Articles = await res.json();
			setData(articles.results);
		})();
	}, []);

	console.log(data);

	return (
		<>
			<header></header>
			<main>
				<p>Palle</p>
			</main>
			<footer></footer>
		</>
	);
}

export default App;
