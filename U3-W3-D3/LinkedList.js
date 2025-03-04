var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
var LinkedListNode = /** @class */ (function () {
    function LinkedListNode(value, next) {
        if (next === void 0) { next = null; }
        this.value = value;
        this.next = next;
    }
    Object.defineProperty(LinkedListNode.prototype, "length", {
        get: function () {
            if (this === null)
                return 0;
            if (this.next === null)
                return 1;
            return 1 + this.next.length;
        },
        enumerable: false,
        configurable: true
    });
    LinkedListNode.prototype.at = function (index) {
        var _a, _b;
        if (this === null)
            return null;
        if (index === 0)
            return this;
        return (_b = (_a = this.next) === null || _a === void 0 ? void 0 : _a.at(index - 1)) !== null && _b !== void 0 ? _b : null;
    };
    LinkedListNode.prototype.getLastNode = function () {
        if (this === null)
            return null;
        if (this.next === null)
            return this;
        return this.next.getLastNode();
    };
    LinkedListNode.prototype.forEach = function (callback, linkedList) {
        function _forEach(node, index) {
            if (node === null)
                return;
            callback(node.value, index, linkedList);
            _forEach(node.next, index + 1);
        }
        _forEach(this, 0);
    };
    LinkedListNode.prototype.reduce = function (callback, accumulator, linkedList) {
        function _reduce(node, index, accumulator) {
            if (node === null)
                return accumulator;
            return _reduce(node.next, index + 1, callback(accumulator, node.value, index, linkedList));
        }
        return _reduce(this, 0, accumulator);
    };
    LinkedListNode.prototype.toArray = function () {
        var _a, _b;
        if (this === null)
            return [];
        return __spreadArray([this.value], ((_b = (_a = this.next) === null || _a === void 0 ? void 0 : _a.toArray()) !== null && _b !== void 0 ? _b : []), true);
    };
    return LinkedListNode;
}());
var LinkedList = /** @class */ (function () {
    function LinkedList() {
        this.head = null;
    }
    Object.defineProperty(LinkedList.prototype, "length", {
        get: function () {
            var _a, _b;
            return (_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.length) !== null && _b !== void 0 ? _b : 0;
        },
        enumerable: false,
        configurable: true
    });
    // INSERT ELEMENT
    LinkedList.prototype.unshift = function (value) {
        this.head = new LinkedListNode(value, this.head);
        return this;
    };
    LinkedList.prototype.push = function (value) {
        if (this.head === null)
            return this.unshift(value);
        this.getLastNode().next = new LinkedListNode(value);
        return this;
    };
    // DELETE ELEMENT
    LinkedList.prototype.shift = function () {
        var _a, _b;
        this.head = (_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.next) !== null && _b !== void 0 ? _b : null;
        return this;
    };
    LinkedList.prototype.pop = function () {
        if (this.head === null)
            return this;
        if (this.length === 1)
            return this.shift();
        this.nodeAt(-2).next = null;
        return this;
    };
    // GET ELEMENT
    LinkedList.prototype.at = function (index) {
        var _a, _b, _c, _d;
        var realIndex = index < 0 ? ((_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.length) !== null && _b !== void 0 ? _b : 0) + index : index;
        var node = (_d = (_c = this.head) === null || _c === void 0 ? void 0 : _c.at(realIndex)) !== null && _d !== void 0 ? _d : null;
        if (node === null)
            throw new Error("Index out of bounce");
        return node.value;
    };
    // NODES
    LinkedList.prototype.getLastNode = function () {
        var _a, _b;
        if (this.head === null)
            throw new Error("List is empty");
        return (_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.getLastNode()) !== null && _b !== void 0 ? _b : this.head;
    };
    LinkedList.prototype.nodeAt = function (index) {
        var _a, _b, _c, _d;
        var realIndex = index < 0 ? ((_b = (_a = this.head) === null || _a === void 0 ? void 0 : _a.length) !== null && _b !== void 0 ? _b : 0) + index : index;
        var node = (_d = (_c = this.head) === null || _c === void 0 ? void 0 : _c.at(realIndex)) !== null && _d !== void 0 ? _d : null;
        if (node === null)
            throw new Error("Index out of bounce");
        return node;
    };
    // ITERATIVES
    LinkedList.prototype.forEach = function (callback) {
        var _a;
        (_a = this.head) === null || _a === void 0 ? void 0 : _a.forEach(callback, this);
    };
    LinkedList.prototype.reduce = function (callback, accumulator) {
        var _a;
        return (_a = this.head) === null || _a === void 0 ? void 0 : _a.reduce(callback, accumulator, this);
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
    return LinkedList;
}());
var linkedList = new LinkedList();
linkedList.unshift(1).push(2).push(3).push(4);
console.log(linkedList.toString());
// console.log(linkedList.length);
// console.log(linkedList.pop().toString());
linkedList.forEach(function (num) { return console.log(num * 2); });
// new LinkedList<number>().forEach((num: number) => num * 2);
var totalSum = linkedList.reduce(function (accumulator, currentValue) {
    return accumulator + currentValue;
}, 0);
console.log(totalSum);
