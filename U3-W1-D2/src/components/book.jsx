import { useState } from "react";

function Book({ book: { title, img, price } }) {
	const [selected, setSelected] = useState(false);

	return (
		<p
			onClick={() => setSelected(!selected)}
			style={selected ? { color: "red" } : null}
		>
			{title}
		</p>
	);
}

export default Book;
