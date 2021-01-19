package com.miguelromero.finapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class FinappApplication

fun main(args: Array<String>) {
	runApplication<FinappApplication>(*args)
}

