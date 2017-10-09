package br.com.bumblebee.congressman.controller

import br.com.bumblebee.congressman.client.CongressmanClient
import br.com.bumblebee.congressman.mapper.toCongressmanResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CongressmanController(val client: CongressmanClient) {

    @GetMapping("/congressman")
    fun congressman(@RequestParam(name = "page", defaultValue = "1") page: Int) =
        toCongressmanResponse(client.getAll(page = page))
}
