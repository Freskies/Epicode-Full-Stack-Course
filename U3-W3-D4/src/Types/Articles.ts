import Result from "./Result";

export default interface Articles {
	readonly count: number;
	readonly next: string;
	readonly previous: null;
	readonly results: Result[];
}
