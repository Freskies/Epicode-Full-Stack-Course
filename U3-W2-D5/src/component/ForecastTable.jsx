import { getEmojiByWeather } from "../myFunctions";

function ForecastTable({ forecast, index }) {
	return (
		<table
			className="forecast-table"
			style={{ transform: `translateX(${index * 100}%)` }}
		>
			<thead>
				<tr>
					<th>Time</th>
					<th>Weather</th>
					<th>Temperature</th>
					<th>Umidity</th>
					<th>Pressure</th>
				</tr>
			</thead>
			<tbody>
				{forecast.map(({ dt_txt, main, weather }) => (
					<tr key={dt_txt}>
						<td>{dt_txt.split(" ")[1].slice(0, 5)}</td>
						<td className="wheather-description">
							<i
								className={`fa ${getEmojiByWeather(weather[0].description)}`}
							></i>
							<span className="description-text">{weather[0].description}</span>
						</td>
						<td>{main.temp}°C</td>
						<td>{main.humidity}%</td>
						<td>{main.pressure}hPa</td>
					</tr>
				))}
			</tbody>
		</table>
	);
}

export default ForecastTable;
