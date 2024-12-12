import { useEffect, useState } from "react";
import Articles from "./components/Articles";
import FactoryHeader from "./components/FactoryHeader";
import ArticleType from "./Types/Articles";
import Result from "./Types/Result";

function App() {
	const [articles, setArticles] = useState<Result[] | null>(null);
	const [loading, setLoading] = useState<boolean>(false);
	const [error, setError] = useState<boolean>(false);

	useEffect(() => {
		(async () => {
			try {
				setLoading(true);
				const res: Response = await fetch(
					"https://api.spaceflightnewsapi.net/v4/articles",
				);
				const data: ArticleType = await res.json();
				setArticles(data.results);
			} catch {
				setError(true);
			} finally {
				setLoading(false);
			}
		})();
	}, []);

	console.log(articles);

	return (
		<>
			<FactoryHeader />
			<main>
				{error ||
					(loading ? (
						<p>Loading...</p>
					) : (
						articles && <Articles articles={articles as Result[]} />
					))}
			</main>
			<footer></footer>
		</>
	);
}

export default App;
