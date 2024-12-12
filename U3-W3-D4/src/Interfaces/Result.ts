import Launch from "./Launch";

export default interface Result {
	readonly id: number;
	readonly title: string;
	readonly url: string;
	readonly imageURL: string;
	readonly newsSite: string;
	readonly summary: string;
	readonly publishedAt: Date;
	readonly updatedAt: Date;
	readonly featured: boolean;
	readonly launches: Launch[];
	readonly events: [];
}
