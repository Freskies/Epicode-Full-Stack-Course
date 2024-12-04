import { useEffect, useState } from "react";
import Film from "./Film";

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

	const updateColumns = () => {
		const carousel = document.querySelector(".carousel");
		const film = document.querySelector(".episode");
		if (!carousel || !film) return;
		setColumns(Math.floor(carousel.clientWidth / (16 + film.clientWidth)));
	};

	useEffect(() => {
		updateColumns();
		window.addEventListener("resize", updateColumns);
	}, []);

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
				<div
					className="content-wrapper"
					style={{ transform: `translateX(-${current * 28}rem)` }}
				>
					{episodes.map(episode => (
						<Film key={episode.imdbID} episode={episode} />
					))}
				</div>
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
