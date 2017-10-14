package br.com.bumblebee

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class Bumblebee

fun main(args: Array<String>) {
    SpringApplication.run(Bumblebee::class.java, *args)
}
