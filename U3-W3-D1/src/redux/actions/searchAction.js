export const SET_SEARCH_RESULTS = "SET_SEARCH_RESULTS";
export const SET_SEARCH_LOADING = "SET_SEARCH_LOADING";
export const SET_SEARCH_ERROR = "SET_SEARCH_ERROR";
export const CLEAR_SEARCH_RESULTS = "CLEAR_SEARCH_RESULTS";

export const setSearchResults = results => ({
	type: SET_SEARCH_RESULTS,
	payload: results,
});

export const setSearchLoading = loading => ({
	type: SET_SEARCH_LOADING,
	payload: loading,
});

export const setSearchError = error => ({
	type: SET_SEARCH_ERROR,
	payload: error,
});

export const clearSearchResults = () => ({
	type: CLEAR_SEARCH_RESULTS,
});
