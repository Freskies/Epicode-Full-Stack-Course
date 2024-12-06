import ForecastTable from "./ForecastTable";
import { useState } from "react";
import { transformDate } from "../myFunctions";

function ForecastPage({ forecast }) {
	const [page, setPage] = useState(4);

	const days = new Set(
		Array.from(forecast, ({ dt_txt }) => dt_txt.split(" ")[0]),
	);
	const pages = Array.from(days, day =>
		forecast.filter(({ dt_txt }) => dt_txt.includes(day)),
	);

	console.log(forecast);

	return (
		<>
			<div className="days-container">
				{Array.from(days).map((day, i) => (
					<button
						key={i}
						className={`day-button ${i === page ? "active" : ""}`}
						onClick={() => setPage(i)}
					>
						<span className="weekday">
							{i === 0 ? "Today" : i === 1 ? "Tomorrow" : transformDate(day)}
						</span>
						<span className="date">{day}</span>
					</button>
				))}
			</div>
			<div className="forecast-table-container">
				{pages.map((elements, i) => (
					<ForecastTable key={i} forecast={elements} index={i - page} />
				))}
			</div>
		</>
	);
}

export default ForecastPage;
