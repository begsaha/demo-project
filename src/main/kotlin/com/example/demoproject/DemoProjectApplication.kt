package com.example.demoproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class DemoProjectApplication

@GetMapping("/version")
fun getVersion():String{
	return "version"

}

fun main(args: Array<String>) {
	runApplication<DemoProjectApplication>(*args)
}



