class myNode<T> {
	value: T;
	next: myNode<T> | null;

	constructor(value: T, next: null | myNode<T> = null) {
		this.value = value;
		this.next = next;
	}

	getLastNode(): myNode<T> | null {
		if (this === null) return null;
		if (this.next === null) return this;
		return this.next.getLastNode();
	}
}

class LinkedList<T> {
	head: myNode<T> | null;

	constructor() {
		this.head = null;
	}

	// INSERT ELEMENT

	/**
	 * Adds a new element to the beginning of the linked list.
	 *
	 * @param value - The value to be added to the list.
	 * @returns The current instance of the linked list.
	 */
	unshift(value: T): this {
		this.head = new myNode(value, this.head);
		return this;
	}

	push(value: T): this {
		if (this.head === null) return this.unshift(value);
		this.getLastNode().next = new myNode<T>(value);
		return this;
	}

	// DELETE ELEMENT

	shift(): this {
		this.head = this.head?.next ?? null;
		return this;
	}

	pop(): this {
		return this;
	}

	// NODES

	getLastNode(): myNode<T> {
		if (this.head === null) throw new Error("List is empty");
		return this.head?.getLastNode() ?? this.head;
	}

	// OTHER

	log() {
		let currentNode = this.head;
		while (currentNode !== null) {
			console.log(currentNode.value);
			currentNode = currentNode.next;
		}
	}

	// TYPE CONVERSION

	toString() {
		return String(this.toArray());
	}

	toArray(): T[] {
		const arr: T[] = [];
		let currentNode = this.head;
		while (currentNode !== null) {
			arr.push(currentNode.value);
			currentNode = currentNode.next;
		}
		return arr;
	}

	static from(array: any[]): LinkedList<any> {
		return new LinkedList();
	}
}

const list = new LinkedList<number>();
list.unshift(1).push(2).push(3).push(4);

console.log(list.toString());
