function BackToHomeArrow({ callback }) {
	return (
		<nav className="back-to-home-navigation">
			<i className="fas fa-arrow-left" onClick={callback}></i>
		</nav>
	);
}

export default BackToHomeArrow;
