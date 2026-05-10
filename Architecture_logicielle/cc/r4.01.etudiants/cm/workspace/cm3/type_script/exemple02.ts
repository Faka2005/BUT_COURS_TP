type User = {
    name: string;
    age: number;
};

function isAdult(user: User): boolean {
    return user.age >= 18;
}

const justine = {
    name: 'Justine',
     age: 23,
} satisfies User;

//const isJustineAnAdult = isAdult(justine);
const user = JSON.parse('{"id": 1, "firstName": "John", age: "38"}') satisfies User
const isJustineAnAdult = isAdult(user);
console.log(user)

 

