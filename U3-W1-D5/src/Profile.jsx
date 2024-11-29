import BackToHomeArrow from "./components/BackToHomeArrow";
import ProfileInfo from "./components/ProfileInfo";

function Profile({ displayHome, profile }) {
	const displayableInfo = { ...profile };
	delete displayableInfo.profileImage;

	return (
		<div className="profile-page">
			<header>
				<BackToHomeArrow callback={displayHome} />
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
			<footer></footer>
		</div>
	);
}

export default Profile;
