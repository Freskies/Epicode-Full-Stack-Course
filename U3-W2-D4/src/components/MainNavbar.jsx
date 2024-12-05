import netflix_logo from "../assets/netflix_logo.png";

function MainNavbar({
	profile: { name: profileImage },
	displayProfile,
	displaySettings,
}) {
	return (
		<nav className="main-navbar" aria-label="navbar">
			<ul className="main-navbar-items">
				<li className="main-navbar-item">
					<img className="netflix-logo" src={netflix_logo} alt="Netflix logo" />
				</li>
				<div className="profile-and-settings-container">
					<li className="main-navbar-item">
						<img
							className="profile-image"
							src={profileImage}
							alt="Profile"
							onClick={displayProfile}
						/>
					</li>
					<li className="main-navbar-item">
						<i
							className="settings-icon fas fa-cog"
							onClick={displaySettings}
						></i>
					</li>
				</div>
			</ul>
		</nav>
	);
}

export default MainNavbar;
