import Result from "../Types/Result";
import Rocket from "./Rocket";

interface ArticleProps {
	article: Result;
}

function Article({ article }: ArticleProps) {
	console.log(article);
	return (
		<article className="article" data-url={article.url}>
			<figure className="card">
				<img src={article.image_url} alt={article.title} />
				<h3>{article.title}</h3>
				<figcaption>{article.summary}</figcaption>
			</figure>
			<Rocket />
		</article>
	);
}

export default Article;
