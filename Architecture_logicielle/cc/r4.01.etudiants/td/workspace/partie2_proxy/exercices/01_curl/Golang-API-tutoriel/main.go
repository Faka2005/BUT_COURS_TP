package main

import (
	"Golang-API-tutoriel/controllers"

	"github.com/gin-gonic/gin"
)

func main() {
	controllers.InitDatabase()

	r := gin.Default()

	r.GET("/book", controllers.FindBooks)
	r.GET("/book/:id", controllers.FindBookByID)
	r.POST("/book", controllers.CreateBook)
	r.DELETE("/book/:id", controllers.DeleteBook)
	r.PUT("/book/:id", controllers.UpdateBook)

	r.Run()
}
