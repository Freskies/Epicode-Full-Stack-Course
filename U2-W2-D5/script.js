// randomize images in carousels
document.addEventListener("DOMContentLoaded", function () {
	const carouselItems = document.querySelectorAll(".carousel-item .row .col");
	const allImages = document.querySelectorAll(".carousel-item img");
	const shuffledImages = Array.from(allImages).sort(() => Math.random() - 0.5);

	carouselItems.forEach((item, i) => {
		item.innerHTML = "";
		for (let j = 0; j < 4; j++) item.appendChild(shuffledImages[i * 4 + j]);
	});
});
