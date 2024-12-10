import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { removeFromFavourites } from "../actions";
import { Link } from "react-router-dom";

const FavouritePage = () => {
	const favourites = useSelector(({ favourites }) => favourites.favourites);
	const dispatch = useDispatch();

	const deleteItem = job => dispatch(removeFromFavourites(job));

	return (
		<div>
			<h1>Favourite Items</h1>
			{favourites.length ? (
				<ul>
					{favourites.map((job, index) => (
						<li key={index}>
							<Link to={`/${job}`}>{job}</Link>
							<button
								style={{ border: "none" }}
								onClick={() => deleteItem(job)}
							>
								🗑️
							</button>
						</li>
					))}
				</ul>
			) : (
				<p>No favourite items found.</p>
			)}
		</div>
	);
};

export default FavouritePage;
