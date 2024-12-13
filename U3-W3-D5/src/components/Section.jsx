import { useState, useEffect } from "react";
import SingleAlbum from "./SingleAlbum";

function Section({ title, secondRowVisible, albums, id }) {
	const [active, setActive] = useState(false);
	const [rows, setRows] = useState(1);

	useEffect(() => {
		const getRows = () => {
			const gridElement = document.querySelector(
				`#${id} .album-section__albums`,
			);
			if (gridElement) {
				const gridStyle = window.getComputedStyle(gridElement);
				const gridTemplateRows = gridStyle.gridTemplateRows.split(" ").length;
				setRows(gridTemplateRows);
			}
		};
		getRows();

		const handleResize = () => {
			getRows();
		};

		window.addEventListener("resize", handleResize);
		return () => {
			window.removeEventListener("resize", handleResize);
		};
	}, [id, secondRowVisible]);

	if (!albums.length) return null;

	return (
		<section className="album-section" id={id}>
			<div className="title-wrapper" onClick={() => setActive(!active)}>
				<h3>{title}</h3>
				<i className={"fas fa-chevron-right" + (active ? " active" : "")}></i>
			</div>

			<div
				className={
					"album-section__albums" +
					(secondRowVisible ? " album-section__albums--second-row-visible" : "")
				}
				style={
					active
						? { height: `calc((var(--new-albums-height) + 8rem) * ${rows})` }
						: {}
				}
			>
				{albums.map(album => (
					<SingleAlbum key={album.id} album={album} />
				))}
			</div>
		</section>
	);
}

export default Section;
