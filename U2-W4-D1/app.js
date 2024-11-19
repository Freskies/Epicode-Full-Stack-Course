"use strict";

const playlist = new Playlist(
	new Song("01"),
	new Song("02"),
	new Song("03"),
	new Song("04"),
);

const musicPlayerElement = document.querySelector(".music-player");
const songElement = document.getElementById("playing-song");
const playPauseButton = document.getElementById("player-play-pause-button");
const nextButton = document.getElementById("player-next-button");
const previousButton = document.getElementById("player-previous-button");

const musicPlayer = new MusicPlayer(
	{
		musicPlayerElement,
		songElement,
		playPauseButton,
		nextButton,
		previousButton,
	},
	playlist,
);
