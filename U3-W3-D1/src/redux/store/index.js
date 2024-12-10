import { configureStore, combineReducers } from "@reduxjs/toolkit";
import favouritesReducer from "../reducers/favouritesReducer";
import searchReducer from "../reducers/searchReducer";

const store = configureStore({
	reducer: combineReducers({
		favourites: favouritesReducer,
		search: searchReducer,
	}),
});

export default store;
