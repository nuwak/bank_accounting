package com.example.banka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BankaApplication

fun main(args: Array<String>) {
    runApplication<BankaApplication>(*args)
}
