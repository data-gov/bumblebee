package br.com.bumblebee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class Bumblebee

fun main(args: Array<String>) {
    runApplication<Bumblebee>(*args)
}
