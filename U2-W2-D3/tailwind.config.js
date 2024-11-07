/** @type {import('tailwindcss').Config} */
module.exports = {
	content: ["./*html"],
	theme: {
		extend: {
			colors: {
				primary: "#7550FE",
				action: "#1ACB98",
				feature: {
					100: "#FFEEDA",
					200: "#C28135",
				},
				secondary: {
					100: "#FFF",
					200: "#F5F4F8",
					300: "#19113C",
				},
			},
		},
		fontFamily: {
			inter: ["Inter", "sans-serif"],
		},
	},
	plugins: [],
};
