class LinkedListNode<T> {
	value: T;
	next: LinkedListNode<T> | null;

	constructor(value: T, next: null | LinkedListNode<T> = null) {
		this.value = value;
		this.next = next;
	}

	get length(): number {
		if (this === null) return 0;
		if (this.next === null) return 1;
		return 1 + this.next.length;
	}

	at(index: number): LinkedListNode<T> | null {
		if (this === null) return null;
		if (index === 0) return this;
		return this.next?.at(index - 1) ?? null;
	}

	getLastNode(): LinkedListNode<T> | null {
		if (this === null) return null;
		if (this.next === null) return this;
		return this.next.getLastNode();
	}

	forEach(callback: Function, linkedList: LinkedList<T>): void {
		function _forEach(node: LinkedListNode<T> | null, index: number): void {
			if (node === null) return;
			callback(node.value, index, linkedList);
			_forEach(node.next, index + 1);
		}
		_forEach(this, 0);
	}

	reduce(
		callback: Function,
		accumulator: any,
		linkedList: LinkedList<T>,
	): void {
		function _reduce(
			node: LinkedListNode<T> | null,
			index: number,
			accumulator: any,
		): any {
			if (node === null) return accumulator;
			return _reduce(
				node.next,
				index + 1,
				callback(accumulator, node.value, index, linkedList),
			);
		}
		return _reduce(this, 0, accumulator);
	}

	toArray(): T[] {
		if (this === null) return [];
		return [this.value, ...(this.next?.toArray() ?? [])];
	}
}

class LinkedList<T> {
	head: LinkedListNode<T> | null;

	constructor() {
		this.head = null;
	}

	get length(): number {
		return this.head?.length ?? 0;
	}

	// INSERT ELEMENT

	unshift(value: T): this {
		this.head = new LinkedListNode(value, this.head);
		return this;
	}

	push(value: T): this {
		if (this.head === null) return this.unshift(value);
		this.getLastNode().next = new LinkedListNode<T>(value);
		return this;
	}

	// DELETE ELEMENT

	shift(): this {
		this.head = this.head?.next ?? null;
		return this;
	}

	pop(): this {
		if (this.head === null) return this;
		if (this.length === 1) return this.shift();
		this.nodeAt(-2).next = null;
		return this;
	}

	// GET ELEMENT

	at(index: number): T {
		const realIndex = index < 0 ? (this.head?.length ?? 0) + index : index;
		const node: LinkedListNode<T> | null = this.head?.at(realIndex) ?? null;
		if (node === null) throw new Error("Index out of bounce");
		return node.value;
	}

	// NODES

	getLastNode(): LinkedListNode<T> {
		if (this.head === null) throw new Error("List is empty");
		return this.head?.getLastNode() ?? this.head;
	}

	nodeAt(index: number): LinkedListNode<T> {
		const realIndex = index < 0 ? (this.head?.length ?? 0) + index : index;
		const node: LinkedListNode<T> | null = this.head?.at(realIndex) ?? null;
		if (node === null) throw new Error("Index out of bounce");
		return node;
	}

	// ITERATIVES

	forEach(callback: Function): void {
		this.head?.forEach(callback, this);
	}

	reduce(callback: Function, accumulator: any): any {
		return this.head?.reduce(callback, accumulator, this);
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
}

const linkedList = new LinkedList<number>();
linkedList.unshift(1).push(2).push(3).push(4);

console.log(linkedList.toString());
// console.log(linkedList.length);
// console.log(linkedList.pop().toString());
linkedList.forEach((num: number): void => console.log(num * 2));
// new LinkedList<number>().forEach((num: number) => num * 2);

const totalSum: number = linkedList.reduce(
	(accumulator: number, currentValue: number): number =>
		accumulator + currentValue,
	0,
);
console.log(totalSum);
