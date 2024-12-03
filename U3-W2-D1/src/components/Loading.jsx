import { useCallback, useEffect, useState } from "react";

function Loading() {
	const dots = ["", ".", "..", "..."];
	const [frame, setFrame] = useState(0);

	const nextFrame = useCallback(
		() => setFrame((frame + 1) % dots.length),
		[dots.length, frame],
	);

	useEffect(() => {
		const interval = setInterval(nextFrame, 500);
		return () => clearInterval(interval);
	}, [nextFrame]);

	return <p className="loading">Loading{dots[frame]}</p>;
}

export default Loading;
