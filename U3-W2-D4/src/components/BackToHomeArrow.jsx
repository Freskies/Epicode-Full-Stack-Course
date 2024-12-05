import { useNavigate } from "react-router";

function BackToHomeArrow() {
	const navigateToHome = useNavigate().bind(null, "/");

	return (
		<nav className="back-to-home-navigation">
			<i className="fas fa-arrow-left" onClick={navigateToHome}></i>
		</nav>
	);
}

export default BackToHomeArrow;
