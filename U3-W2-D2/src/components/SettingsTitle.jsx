import React, { useState } from "react";

function SettingsTitle({ title, changeSeries, removeSeries }) {
	// HANDLE TITLE CHANGE
	const [inputValue, setInputValue] = useState(title);
	const handleInputChange = e => setInputValue(e.target.value);
	const handleInputBlur = () => changeSeries(title, inputValue);

	return (
		<div className="settings-title">
			<input
				className="title-input"
				type="text"
				value={inputValue}
				onChange={handleInputChange}
				onBlur={handleInputBlur}
			/>
			<button className="delete-button" onClick={() => removeSeries(title)}>
				<i className="fas fa-trash"></i>
			</button>
		</div>
	);
}

export default SettingsTitle;
