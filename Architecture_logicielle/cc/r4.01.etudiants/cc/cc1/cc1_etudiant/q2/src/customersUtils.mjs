

const customersUtils=(customers) => {
    //Le nombre de clients
    const current = {
        number: () =>{
            return customers.length
        },
        /**
         * Les clients dont le genre est M
         * @returns Array
         */
        masculineGenders: () => {
            return customers.filter(c=>c.c.gender=="M")
        },

        /**
         * L'age du client le plus agé, -1 si pas de client
         * @returns {number|number}
         */
        olderAge: () => {
            if (customers.length==0) {
                return -1
            }
            let maxAge = customers[0].age
            for (let index = 1; index < customers.length; index++) {
                const element = customers[index];
                if (element.age>maxAge) {
                    maxAge=element.age
                }
                
            }   return maxAge
        },

        /**
         * Les clients les plus agés, [] si pas de client
         * @returns Array
         */
        oldestCustomers: () => {
            if (customers.length==0) {
                return []
            }

            let maxAge = customers[0].age
            for (let index = 1; index < customers.length; index++) {
                const element = customers[index];
                if (element.age>maxAge) {
                    maxAge=element.age
                }
                
            }   
            return customers.filter(c=>c.age==maxAge)
        },

        /**
         * Les clients ayant achété un produit
         * @param purchased un entier
         * @returns Array
         */
        customersWhoPurchased: (purchased) => {
            return customers.filter(c=>c.purchased.includes(purchased))
        }
    }
    return current
}
export default customersUtils
