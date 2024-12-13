import { useState } from "react";

function SearchBar() {
	const [searchText, setSearchText] = useState("");

	const handleChange = e => setSearchText(e.target.value);

	return (
		<div className="search-wrapper">
			<input
				type="text"
				value={searchText}
				onChange={handleChange}
				placeholder="Cerca"
			/>
			<i className="fas fa-search"></i>
		</div>
	);
}

export default SearchBar;
