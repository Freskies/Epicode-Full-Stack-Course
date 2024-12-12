function FactoryHeader() {
	return (
		<header className="factory-header">
			<div className="factory-conveyor-belt factory-conveyor-belt--in"></div>
			<div className="factory-wrapper">
				<div className="factory-wall">
					<h1>Spaceflight Factory News</h1>
					<div className="chimney">
						<div className="steam"></div>
					</div>
				</div>
				<div className="factory-loading"></div>
			</div>
			<div className="factory-conveyor-belt factory-conveyor-belt--out"></div>
		</header>
	);
}

export default FactoryHeader;
