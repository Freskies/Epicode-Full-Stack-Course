import Footer from "./components/Footer";
import MainNavbar from "./components/MainNavbar";
import Series from "./components/Series";

function Home({
	profile,
	displayProfile,
	displaySettings,
	series,
	IDBD_API_KEY,
}) {
	return (
		<div className="home-page">
			<header>
				<MainNavbar
					profile={profile}
					displayProfile={displayProfile}
					displaySettings={displaySettings}
				/>
			</header>
			<main>
				{series.map(
					title =>
						title && (
							<Series key={title} title={title} IDBD_API_KEY={IDBD_API_KEY} />
						),
				)}
			</main>
			<Footer />
		</div>
	);
}

export default Home;
