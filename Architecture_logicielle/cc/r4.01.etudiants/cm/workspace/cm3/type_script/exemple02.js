function isAdult(user) {
    return user.age >= 18;
}
var justine = {
    name: 'Justine',
    age: 23,
};
//const isJustineAnAdult = isAdult(justine);
var user = JSON.parse('{"id": 1, "firstName": "John", age: "38"}');
var isJustineAnAdult = isAdult(user);
console.log(user);
