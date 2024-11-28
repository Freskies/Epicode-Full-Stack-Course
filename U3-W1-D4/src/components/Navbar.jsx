function Navbar({
	currentGenres,
	toggleGenre,
	currentSearchText,
	setCurrentSearchText,
}) {
	return (
		<nav className="navbar">
			<ul className="navbar-links">
				<li>
					<select value="filter" onChange={e => toggleGenre(e.target.value)}>
						<option value="filter">FILTERS:</option>
						{Object.keys(currentGenres).map(genre => (
							<option key={genre} value={genre}>
								{currentGenres[genre] && "✔️"}
								{genre}
							</option>
						))}
					</select>
				</li>
				<li>
					<span>🔎</span>
					<input
						type="text"
						value={currentSearchText}
						onChange={e => setCurrentSearchText(e.target.value)}
					/>
				</li>
			</ul>
		</nav>
	);
}

export default Navbar;
