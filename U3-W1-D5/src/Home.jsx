import MainNavbar from "./components/MainNavbar";

function Home({ profile, displayProfile, displaySettings }) {
	return (
		<div className="home-page">
			<header>
				<MainNavbar
					profile={profile}
					displayProfile={displayProfile}
					displaySettings={displaySettings}
				/>
			</header>
			<main></main>
			<footer></footer>
		</div>
	);
}

export default Home;
