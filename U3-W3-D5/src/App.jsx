import { useEffect, useState } from "react";
import AppleMusicLogo from "./components/AppleMusicLogo";
import SearchBar from "./components/searchBar";
import AsideSubMenu from "./components/AsideSubMenu";
import Loading from "./components/Loading";
import Section from "./components/Section";
import radioAlbums from "./albumInfo/radio_episode.json";
import banners from "./albumInfo/banner_album.json";
import explore from "./albumInfo/more_to_explore.json";
import Apple from "./components/Apple";

import ba from "./assets/images/1a.png";
import bb from "./assets/images/1b.png";
import bc from "./assets/images/1c.png";

import r2a from "./assets/images/2a.png";
import r2b from "./assets/images/2b.png";
import r2c from "./assets/images/2c.png";
import r2d from "./assets/images/2d.png";
import r2e from "./assets/images/2e.png";
import r2f from "./assets/images/2f.png";
import Footer from "./components/Footer";

const bs = [ba, bb, bc];
const rs = [r2a, r2b, r2c, r2d, r2e, r2f];

function App() {
	const [activeSideBar, setActiveSideBar] = useState(false);

	const trueRadioAlbums = radioAlbums.map((radioAlbum, i) => ({
		...radioAlbum,
		cover: rs[i],
	}));

	const trueBanners = banners.map((banner, i) => ({
		...banner,
		cover: bs[i],
	}));

	const [newAlbums, setNewAlbums] = useState([]);
	const [loadingNewAlbums, setLoadingNewAlbums] = useState(true);
	const [errorNewAlbums, setErrorNewAlbums] = useState(false);

	useEffect(() => {
		(async () => {
			try {
				const response = await fetch(
					"https://striveschool-api.herokuapp.com/api/deezer/search?q=metal",
				);
				if (response.ok) {
					const data = await response.json();
					const albums = data.data.map(newAlbum => ({
						id: newAlbum.id,
						cover: newAlbum.album.cover_xl,
						firstCaption: newAlbum.title,
						secondCaption: newAlbum.artist.name,
					}));
					console.log(data.data);
					setNewAlbums(albums);
				} else {
					throw new Error("Failed to fetch new albums");
				}
			} catch (error) {
				setErrorNewAlbums(true);
				console.error(error);
			} finally {
				setLoadingNewAlbums(false);
			}
		})();
		setLoadingNewAlbums(true);
	}, []);

	return (
		<>
			<nav className="navbar">
				<i
					className="fas fa-bars"
					onClick={() => setActiveSideBar(!activeSideBar)}
				></i>
				<div className="player-buttons">
					<i className="fas fa-random"></i>
					<i className="fas fa-step-backward"></i>
					<i className="fas fa-play"></i>
					<i className="fas fa-step-forward"></i>
					<i className="fas fa-redo"></i>
				</div>
				<div className="apple-container">
					<Apple />
				</div>
				<div className="player-bar">
					<i className="fas fa-volume-up"></i>
					<div className="volume-bar">
						<div className="volume"></div>
					</div>
				</div>
				<button className="login">
					<i className="fas fa-user"></i>
					<span>Accedi</span>
				</button>
			</nav>
			<aside className={`sidebar ${activeSideBar ? "active" : ""}`}>
				<AppleMusicLogo />
				<SearchBar />
				<AsideSubMenu />
			</aside>
			<main className="main">
				<h2>Novità</h2>
				<section className="banner-section">
					{trueBanners.map(({ id, cover, firstCaption }) => (
						<article key={id} className="banner">
							<div className="banner-content">
								<p className="new-radio">nuova stazione radio</p>
								<p className="caption">{firstCaption}</p>
							</div>
							<img src={cover} alt="banner" />
						</article>
					))}
				</section>
				<Section
					title="Nuovi episodi radio"
					secondRowVisible={false}
					albums={trueRadioAlbums}
					id="section-radio"
				/>
				{errorNewAlbums ||
					(loadingNewAlbums ? (
						<Loading />
					) : (
						<Section
							title="Nuove uscite"
							secondRowVisible={true}
							albums={newAlbums}
							id={"section-new-albums"}
						/>
					))}
				<section className="more-to-explore-section">
					<h3>Altro da esplorare</h3>
					<div className="explore-container">
						{explore.map(({ id, label }) => (
							<article key={id} className="explore-content">
								<span>{label}</span>
								<i className="fas fa-chevron-right"></i>
							</article>
						))}
					</div>
				</section>
			</main>
			<Footer />
		</>
	);
}

export default App;
