import BackToHomeArrow from "./components/BackToHomeArrow";
import Footer from "./components/Footer";
import SettingsTitle from "./components/SettingsTitle";

const requests = [
	"I want to recieve notifications",
	"I want to recieve emails",
	"I want to recieve newsletters",
	"I want to recieve offers",
	"I want to recieve updates",
	"I want to recieve Gigi Sabani",
];

function Settings({
	displayHome,
	series,
	changeSeries,
	addSeries,
	removeSeries,
}) {
	return (
		<div className="settings-page">
			<header>
				<BackToHomeArrow callback={displayHome} />
			</header>
			<main>
				<div className="settings-wrapper">
					<div className="search-wrapper">
						<h3>Series to display on your home</h3>
						{series.map(title => (
							<SettingsTitle
								key={title.replace(/\s/g, "")}
								title={title}
								changeSeries={changeSeries}
								removeSeries={removeSeries}
							/>
						))}
						{/* button add series */}
						<button className="add-series-btn" onClick={() => addSeries("")}>
							<i className="fas fa-plus"></i>
						</button>
					</div>
					<div className="checkboxes-wrapper">
						<h3>Policy</h3>
						{requests.map((request, i) => (
							<div key={i} className="checkbox-wrapper">
								<label>
									<input type="checkbox" />
									{request}
								</label>
							</div>
						))}
					</div>
				</div>
			</main>
			<Footer />
		</div>
	);
}

export default Settings;
