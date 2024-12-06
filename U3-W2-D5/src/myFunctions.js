export function getMonth(month) {
	const months = [
		"January",
		"February",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September",
		"October",
		"November",
		"December",
	];
	return months[month + 1];
}

export function getDay(day) {
	const days = [
		"Sunday",
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday",
		"Saturday",
	];
	return days[day];
}

export function transformDate(date) {
	const [year, month, day] = date.split("-");
	const dateObj = new Date(year, month - 1, day);
	const weekday = dateObj.getDay();
	return getDay(weekday);
}

export function getEmojiByWeather(weather) {
	const emojis = {
		"clear sky": "fa-sun",
		"few clouds": "fa-cloud-sun",
		"scattered clouds": "fa-cloud-sun",
		"broken clouds": "fa-cloud-sun",
		"shower rain": "fa-cloud-showers-heavy",
		rain: "fa-cloud-rain",
		thunderstorm: "fa-bolt",
		snow: "fa-snowflake",
		mist: "fa-smog",
		"overcast clouds": "fa-cloud",
		"light rain": "fa-cloud-rain",
		"moderate rain": "fa-cloud-rain",
		"heavy intensity rain": "fa-cloud-showers-heavy",
		"light intensity shower rain": "fa-cloud-showers-heavy",
		"light snow": "fa-snowflake",
		"light intensity drizzle": "fa-cloud-rain",
		"light intensity drizzle rain": "fa-cloud-rain",
		"light intensity shower rain and snow": "fa-cloud-showers-heavy",
	};
	return emojis[weather];
}
