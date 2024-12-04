import Footer from "./components/Footer";
import MainNavbar from "./components/MainNavbar";
import Series from "./components/Series";
import { useNavigate } from "react-router";

function Home({ profile, series, IDBD_API_KEY }) {
	const navigator = useNavigate();
	const navigateToProfile = navigator.bind(null, "/profile");
	const navigateToSettings = navigator.bind(null, "/settings");

	return (
		<div className="home-page">
			<header>
				<MainNavbar
					profile={profile}
					displayProfile={navigateToProfile}
					displaySettings={navigateToSettings}
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
