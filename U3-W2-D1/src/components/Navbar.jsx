function Navbar({ search, setSearch }) {
	const setSearchByInput = e => setSearch(e.target.value);

	return (
		<nav className="navigation">
			<div className="search-wrapper">
				<input
					className="search"
					type="text"
					value={search}
					onChange={setSearchByInput}
				/>
				<i className="fa fa-search"></i>
			</div>
		</nav>
	);
}

export default Navbar;
