

const customersUtils=(customers) => {
    //Le nombre de clients
    const current = {
        number: () =>
            customers.length,
        /**
         * Les clients dont le genre est M
         * @returns Array
         */
        masculineGenders: () => {
            return customers.filter(c => c.gender === 'M');

        },


        /**
         * L'age du client le plus agé, -1 si pas de client
         * @returns {number|number}
         */
        olderAge: () => {
            if (customers.length === 0) return -1;
            var maxAge=0
            for (let i = 0; i < customers.length; i++) {
                if (customers[i].age >maxAge)  {
                    maxAge = customers[i].age
                }
            }
            return maxAge
        },

        /**
         * Les clients les plus agés, [] si pas de client
         * @returns Array
         */
        oldestCustomers: () => {
            if (customers.length === 0) return [];
            const maxAge = Math.max(...customers.map(c => c.age));
            return customers.filter(c => c.age === maxAge);
        },

        /**
         * Les clients ayant achété un produit
         * @param purchased un entier
         * @returns Array
         */
        customersWhoPurchased: (purchased) => {
            var list=[]

            for (let index = 0; index < customers.length; index++) {
                const element = customers[index];
                if(element.purchased.includes(purchased)){
                    list.push(element)
                }
                
            }
            return list
        }
    }
    return current
}
export default customersUtils
