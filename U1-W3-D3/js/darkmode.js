let darkmode = localStorage.getItem("darkmode");
const themeSwitch = document.getElementById("theme-switch");

const enableDarkMode = function () {
	document.body.classList.add("darkmode");
	localStorage.setItem("darkmode", "active");
};

const disableDarkMode = function () {
	document.body.classList.remove("darkmode");
	localStorage.setItem("darkmode", null);
};

if (darkmode === "active") enableDarkMode();

themeSwitch.addEventListener("click", () => {
	darkmode = localStorage.getItem("darkmode");
	darkmode !== "active" ? enableDarkMode() : disableDarkMode();
});
