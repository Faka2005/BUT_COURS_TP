package main

import "fmt"


func puissance(x, n int) (res int) {
	res = 1 
	acc := x
	for exp:=n ; exp > 0;  {
		if exp % 2 == 0 {
			acc = acc * acc
			exp = exp >> 1
		} else {
			res = res * acc
			acc = acc * acc
			exp = (exp - 1) >> 1
		}
	}
	return
}


func main() {

	for i := 3; i < 13; i++ {
		for j := 3; j < 13; j++ {
			res := puissance(i, j)
			fmt.Println(i, "^", j, "=", res)
		}
	}

}
