import {
	SET_SEARCH_RESULTS,
	SET_SEARCH_LOADING,
	SET_SEARCH_ERROR,
	CLEAR_SEARCH_RESULTS,
} from "../actions/searchAction";

const initialState = {
	searched: [],
	loading: false,
	error: null,
};

const searchReducer = (state = initialState, { type, payload }) => {
	switch (type) {
		case SET_SEARCH_RESULTS:
			return {
				...state,
				searched: payload,
			};
		case SET_SEARCH_LOADING:
			return {
				...state,
				loading: payload,
			};
		case SET_SEARCH_ERROR:
			return {
				...state,
				error: payload,
			};
		case CLEAR_SEARCH_RESULTS:
			return {
				...state,
				searched: [],
			};
		default:
			return state;
	}
};

export default searchReducer;
