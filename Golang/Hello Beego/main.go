package main

import "github.com/astaxie/beego"

type MainController struct {
	beego.Controller
}

func (c *MainController) Get() {
	c.Ctx.WriteString("Hello, world")
}

func main() {
	beego.RESTRouter("/", &MainController{})
	beego.Run()
}
