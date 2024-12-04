import BackToHomeArrow from "./components/BackToHomeArrow";
import Footer from "./components/Footer";
import ProfileInfo from "./components/ProfileInfo";

function Profile({ profile }) {
	const displayableInfo = { ...profile };
	delete displayableInfo.profileImage;

	return (
		<div className="profile-page">
			<header>
				<BackToHomeArrow />
			</header>
			<main>
				<div className="profile-wrapper">
					<div className="profile-image-wrapper">
						<img
							className="profile-image"
							src={profile.profileImage}
							alt="Profile"
						/>
					</div>
					<div className="profile-info">
						{Object.entries(displayableInfo).map(([key, value], i) => (
							<ProfileInfo key={i} infoKey={key} infoValue={value} />
						))}
					</div>
				</div>
			</main>
			<Footer />
		</div>
	);
}

export default Profile;
