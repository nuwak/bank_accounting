package com.example.banka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class bankaApplication

fun main(args: Array<String>) {
    runApplication<bankaApplication>(*args)
}
