import { Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { addFavourite, removeFromFavourites } from "../actions";

const Job = ({ data }) => {
	const dispatch = useDispatch();
	const addItem = () => dispatch(addFavourite(data.company_name));
	const removeItem = () => dispatch(removeFromFavourites(data.company_name));
	const favourites = useSelector(({ favourites }) => favourites.favourites);

	return (
		<Row
			className="mx-0 mt-3 p-3"
			style={{ border: "1px solid #00000033", borderRadius: 4 }}
		>
			<Col xs={3}>
				<Link to={`/${data.company_name}`}>{data.company_name}</Link>
				<button style={{ border: "none" }} onClick={addItem}>
					⭐
				</button>
				{favourites.some(item => item === data.company_name) && (
					<button style={{ border: "none" }} onClick={removeItem}>
						🗑️
					</button>
				)}
			</Col>
			<Col xs={9}>
				<a href={data.url} target="_blank" rel="noreferrer">
					{data.title}
				</a>
			</Col>
		</Row>
	);
};
export default Job;
