import { useState, useEffect } from "react";

function Loading() {
	const dots = ["", ".", "..", "..."];
	const [dot, setDot] = useState(0);

	useEffect(() => {
		const interval = setInterval(() => {
			setDot(dot => (dot + 1) % dots.length);
		}, 500);
		return () => clearInterval(interval);
	}, [dots.length]);

	return <p>Loading{dots[dot]}</p>;
}

export default Loading;
