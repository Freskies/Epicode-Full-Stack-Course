import { useState } from "react";

function Carousel({ episodes }) {
	const [columns, setColumns] = useState(4);
	const [current, setCurrent] = useState(0);

	const canScrollLeft = current > 0;
	const canScrollRight = current + columns < episodes.length;

	const scrollRight = () => {
		setCurrent(
			current + columns * 2 >= episodes.length
				? episodes.length - columns
				: current + columns,
		);
	};
	const scrollLeft = () => {
		setCurrent(current - columns < 0 ? 0 : current - columns);
	};

	return (
		<div className="carousel">
			<button
				className="scroll-left"
				onClick={scrollLeft}
				disabled={!canScrollLeft}
				style={canScrollLeft ? {} : { opacity: "0" }}
			>
				<i className="fas fa-chevron-left"></i>
			</button>
			<div className="carousel-content">
				{episodes.slice(current, current + columns).map(episode => (
					<img
						className="episode"
						key={episode.imdbID}
						src={episode.Poster}
						alt=""
					/>
				))}
			</div>
			<button
				className="scroll-right"
				onClick={scrollRight}
				disabled={!canScrollRight}
				style={canScrollRight ? {} : { opacity: "0" }}
			>
				<i className="fas fa-chevron-right"></i>
			</button>
		</div>
	);
}

export default Carousel;
