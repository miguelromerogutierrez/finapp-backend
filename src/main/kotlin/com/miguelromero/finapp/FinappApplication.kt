package com.miguelromero.finapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FinappApplication

fun main(args: Array<String>) {
	runApplication<FinappApplication>(*args)
}
