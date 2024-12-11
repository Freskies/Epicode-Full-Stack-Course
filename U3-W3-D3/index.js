function es1() {
    console.log("number, string, undefined, null, boolean, bigInt, symbol, any");
}
function es2() {
    var myName = "Valerio";
    var myAge = 21;
    var iAmStudyngTypescript = true;
}
function es3() {
    var greet = function (personName) { return "Ciao " + personName; };
}
function es4() {
    var sum = function (a, b) { return a + b; };
    console.log(sum(10, 15));
}
function es5() {
    var applyIVA = function (price) { return price * 1.22; };
    console.log(applyIVA(10));
}
function es6() {
    var sumLength = function () {
        var strings = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            strings[_i] = arguments[_i];
        }
        return strings.reduce(function (acc, cur) { return acc + cur.length; }, 0);
    };
    console.log(sumLength("ciao", "culo"));
}
function es7() {
    console.log("|: is used to be able to declare multiple possible type for a variable");
}
function es8() {
    var myVar = 5;
}
function es9() {
    var Days;
    (function (Days) {
        Days[Days["Monday"] = 0] = "Monday";
        Days[Days["Tuesday"] = 1] = "Tuesday";
        Days[Days["Wednesday"] = 2] = "Wednesday";
        Days[Days["Thursday"] = 3] = "Thursday";
        Days[Days["Friday"] = 4] = "Friday";
        Days[Days["Saturday"] = 5] = "Saturday";
        Days[Days["Sunday"] = 6] = "Sunday";
    })(Days || (Days = {}));
    var getDay = function (day) { return Days[day]; };
    var day = Days.Monday;
    console.log(getDay(day));
}
function es10() {
    var numbers1 = [1, 2, 3];
    var numbers2 = [1, 2, 3];
}
function es11() {
    var person = ["a", "b", "c", 1, 2];
    console.log(person);
}
function es12() {
    console.log("your mother");
}
function es13() {
    var valerio = {
        firstname: "Valerio",
        lastname: "Giacchini",
        age: 21,
    };
    console.log(valerio);
}
function es14() {
    var valerio = {
        email: "freskies.bico.apo@gmail.com",
    };
    console.log(valerio);
}
function es15() {
    var valerio = {
        studentName: "Valerio",
        grade: 11,
    };
    var arr = [valerio];
}
function es16_17() {
    var myCar = {
        make: "Toyota",
        model: "Corolla",
        year: 2020,
        color: "red",
    };
    console.log(myCar);
}
function es18() {
    console.log("your sister!");
}
function es19() {
    console.log("yes");
}
