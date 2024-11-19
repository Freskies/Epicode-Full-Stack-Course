class MusicPlayer {
	// HTML ELEMENTS
	#musicPlayerElement;
	#songElement;
	#playPauseButton;
	#nextButton;
	#previousButton;

	// MUSIC PLAYER
	#playlist;
	#volume = 0.005;

	/**
	 * Creates an instance of the music player.
	 *
	 * @constructor
	 * @param {Object} elements - The HTML elements required for the music player.
	 * @param {HTMLElement} elements.musicPlayerElement - The main container element for the music player.
	 * @param {HTMLElement} elements.songElement - The audio element that plays the song.
	 * @param {HTMLElement} elements.playPauseButton - The button to play or pause the song.
	 * @param {HTMLElement} elements.nextButton - The button to skip to the next song.
	 * @param {HTMLElement} elements.previousButton - The button to go back to the previous song.
	 * @param {Playlist} playlist - The playlist to play.
	 * @throws {Error} Throws an error if any of the provided elements are not instances of HTMLElement.
	 */
	constructor(
		{
			musicPlayerElement,
			songElement,
			playPauseButton,
			nextButton,
			previousButton,
		},
		playlist,
	) {
		// VALIDATE HTML ELEMENTS
		for (const element of [
			musicPlayerElement,
			songElement,
			playPauseButton,
			nextButton,
			previousButton,
		]) {
			if (!element instanceof HTMLElement) {
				throw new Error(
					"Invalid HTML element: all HTML elements must be instances of HTMLElement",
				);
			}
		}

		// ASSIGN HTML ELEMENTS
		this.#musicPlayerElement = musicPlayerElement;
		this.#songElement = songElement;
		this.#playPauseButton = playPauseButton;
		this.#nextButton = nextButton;
		this.#previousButton = previousButton;

		// ASSIGN PLAYLIST
		this.playlist = playlist;

		// VOLUME
		this.#songElement.volume = this.#volume;

		// EVENT LISTENERS
		this.#songElement.addEventListener("ended", () => this.#next());
		this.#playPauseButton.addEventListener("click", () => this.#playPause());
		this.#nextButton.addEventListener("click", () => this.#next());
		this.#previousButton.addEventListener("click", () => this.#previous());
	}

	// GETTERS AND SETTERS

	get playlist() {
		return this.#playlist;
	}

	set playlist(playlist) {
		if (!(playlist instanceof Playlist))
			throw new Error(
				"Invalid playlist: the playlist must be an instance of the Playlist class",
			);
		this.#playlist = playlist;
	}

	// METHODS

	play() {
		this.#musicPlayerElement.dataset.playing = "true";
		this.#songElement.play();
	}

	pause() {
		this.#musicPlayerElement.dataset.playing = "false";
		this.#songElement.pause();
	}

	#playPause() {
		if (this.#musicPlayerElement.dataset.playing === "true") this.pause();
		else this.play();
	}

	#next() {
		this.#changeSong(this.#playlist.next());
	}

	#previous() {
		this.#changeSong(this.#playlist.previous());
	}

	#changeSong(song) {
		this.#songElement.src = `assets/${song.src}.mp3`;
		this.play();
	}
}
