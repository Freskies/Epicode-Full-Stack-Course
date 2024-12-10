export const ADD_TO_FAVOURITES = "ADD_TO_FAVOURITES";
export const REMOVE_FROM_FAVOURITES = "REMOVE_FROM_FAVOURITES";

export const addFavourite = job => ({
	type: ADD_TO_FAVOURITES,
	payload: job,
});

export const removeFromFavourites = job => ({
	type: REMOVE_FROM_FAVOURITES,
	payload: job,
});
