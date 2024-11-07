const mainNavigation = document.getElementById("main-navigation");

mainNavigation.addEventListener("click", e => {
	console.log(e.target);
	// if the clicked element is a fakeDropdown toggle it
	if (e.target.classList.contains("fake-dropdown")) {
		const dataToggle = e.target.getAttribute("data-dropdown");
		console.log(dataToggle);
		e.target.setAttribute(
			"data-dropdown",
			dataToggle === "true" ? "false" : "true",
		);
	}
});
