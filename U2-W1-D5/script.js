"use strict";

/////////////////////////////
// STICKY SCROLL
////////////////////////////

const header = document.querySelector(".header");
const hero = document.querySelector(".section-hero");
const scrolledHeight = hero.offsetHeight - header.offsetHeight;

window.addEventListener("scroll", () => {
	if (window.scrollY > scrolledHeight) header.classList.add("scrolled");
	else header.classList.remove("scrolled");
});

/////////////////////////////
// M-ANIMATION
////////////////////////////

// set css variable for the "media-query" scrolling
const title = document.querySelector(".hero-wrapper");
const titleWidth = title.offsetWidth;
document.documentElement.style.setProperty(
	"--hero-wrapper-width",
	`${titleWidth}px`,
);

// actual animation
const allM = document.querySelectorAll(`.m-layout g[stroke-linecap="butt"]`);

const animateM = () => {
	const m = allM[Math.floor(Math.random() * allM.length)];
	m.style.opacity = (m.style.opacity - 0 + 1) % 2;
};

setInterval(animateM, 16);
