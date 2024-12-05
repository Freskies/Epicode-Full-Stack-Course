function ProfileInfo({ infoKey, infoValue }) {
	return (
		<div className="profile-property">
			<p className="profile-property-name">{infoKey}:</p>
			<p className="profile-property-value">{infoValue}</p>
		</div>
	);
}

export default ProfileInfo;
