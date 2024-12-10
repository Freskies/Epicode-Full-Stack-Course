import { ADD_TO_FAVOURITES, REMOVE_FROM_FAVOURITES } from "../../actions";

const initialState = {
	favourites: [],
};

const mainReducer = (state = initialState, { type, payload }) => {
	switch (type) {
		case ADD_TO_FAVOURITES:
			return {
				...state,
				favourites: [...new Set(state.favourites).add(payload)],
			};
		case REMOVE_FROM_FAVOURITES:
			return {
				...state,
				favourites: state.favourites.filter(fav => fav !== payload),
			};
		default:
			return state;
	}
};

export default mainReducer;
