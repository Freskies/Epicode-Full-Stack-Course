var myNode = /** @class */ (function () {
    function myNode(value, next) {
        if (next === void 0) { next = null; }
        this.value = value;
        this.next = next;
    }
    myNode.prototype.getLastNode = function () {
        if (this === null)
            return null;
        if (this.next === null)
            return this;
        return this.next.getLastNode();
    };
    return myNode;
}());
var LinkedList = /** @class */ (function () {
    function LinkedList() {
        this.head = null;
    }
    // INSERT ELEMENT
    /**
     * Adds a new element to the beginning of the linked list.
     *
     * @param value - The value to be added to the list.
     * @returns The current instance of the linked list.
     */
    LinkedList.prototype.unshift = function (value) {
        this.head = new myNode(value, this.head);
        return this;
    };
    LinkedList.prototype.push = function (value) {
        if (this.head === null)
            return this.unshift(value);
        this.getLastNode().next = new myNode(value);
        return this;
    };
    // DELETE ELEMENT
    LinkedList.prototype.shift = function () {
        var _a, _b;
        this.head = (_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.next) !== null && _b !== void 0 ? _b : null;
        return this;
    };
    LinkedList.prototype.pop = function () {
        return this;
    };
    // NODES
    LinkedList.prototype.getLastNode = function () {
        var _a, _b;
        if (this.head === null)
            throw new Error("List is empty");
        return (_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.getLastNode()) !== null && _b !== void 0 ? _b : this.head;
    };
    // OTHER
    LinkedList.prototype.log = function () {
        var currentNode = this.head;
        while (currentNode !== null) {
            console.log(currentNode.value);
            currentNode = currentNode.next;
        }
    };
    // TYPE CONVERSION
    LinkedList.prototype.toString = function () {
        return String(this.toArray());
    };
    LinkedList.prototype.toArray = function () {
        var arr = [];
        var currentNode = this.head;
        while (currentNode !== null) {
            arr.push(currentNode.value);
            currentNode = currentNode.next;
        }
        return arr;
    };
    LinkedList.from = function (array) {
        return new LinkedList();
    };
    return LinkedList;
}());
var list = new LinkedList();
list.unshift(1).push(2).push(3).push(4);
console.log(list.toString());
