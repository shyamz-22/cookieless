package com.ennovate.cookieless

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CookielessApplication

fun main(args: Array<String>) {
    SpringApplication.run(CookielessApplication::class.java, *args)
}
