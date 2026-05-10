"use strict"
const carre=(n)=>{

    if(n<0)throw new Error("Must be positive or null")
    if(n===0) return '\n'

    let res=''
    for(let i=1; i<=n; i++) {
        for (let j = 1; j <= n; j++)
            res += "*"
        res+='\n'
    }
    if (res=='')
        res='\n'
    return res

}
export default carre
console.log(carre(2))