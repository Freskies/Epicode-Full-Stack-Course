function Navbar({ genre, setGenre, searchText, setSearchText, bookGenres }) {
	return (
		<nav>
			<ul>
				<li>Home</li>
				<li>About</li>
				<li>Browse</li>
				<li>
					<select value={genre} onChange={e => setGenre(e.target.value)}>
						{bookGenres.map((bookGenre, i) => (
							<option key={i}>{bookGenre}</option>
						))}
					</select>
				</li>
				<li>
					<input
						type="text"
						value={searchText}
						onChange={e => setSearchText(e.target.value)}
					/>
				</li>
			</ul>
		</nav>
	);
}

export default Navbar;
