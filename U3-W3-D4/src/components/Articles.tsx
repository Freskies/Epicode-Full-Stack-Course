import Result from "./../Types/Result";
import Article from "./Article";

interface ArticlesProps {
	articles: Result[];
}

function Articles({ articles }: ArticlesProps) {
	const hadleClick = e => {
		const article = e.target.closest(".article");
		if (!article) return;
		const url = article.getAttribute("data-url");
		window.open(url, "_blank");
	};

	return (
		<section className="articles" onClick={hadleClick}>
			{articles.map((article, i: number) => (
				<Article key={i} article={article} />
			))}
		</section>
	);
}

export default Articles;
