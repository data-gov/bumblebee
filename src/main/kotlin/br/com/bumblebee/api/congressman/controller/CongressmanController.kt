package br.com.bumblebee.api.congressman.controller

import br.com.bumblebee.api.congressman.service.CongressmanService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CongressmanController(val service: CongressmanService) {

    @GetMapping(path = arrayOf("/congressmen"))
    fun get() = service.saveAllCongressman()
}

