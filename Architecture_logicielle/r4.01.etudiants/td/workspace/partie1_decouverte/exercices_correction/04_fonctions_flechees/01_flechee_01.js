const tab = [10,20,0,5,8,12]
const tab2 = tab.map(note => note < 20 ? note+1 : note)
console.log(tab2)


const initialValue = 0;
const somme = tab2.reduce(
    (accumulator, currentValue) => accumulator + currentValue, initialValue
);
console.log(somme)
console.log(somme/tab2.length)