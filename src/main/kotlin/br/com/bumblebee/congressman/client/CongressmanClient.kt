package br.com.bumblebee.congressman.client

import br.com.bumblebee.configuration.feign.FeignConfiguration
import br.com.bumblebee.congressman.client.model.CongressmanClientResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "client", url = "\${camara.api}", configuration = arrayOf(FeignConfiguration::class))
interface CongressmanClient {

    @GetMapping(path = arrayOf("deputados"), produces = arrayOf(APPLICATION_JSON_UTF8_VALUE))
    fun getAll(@RequestParam(name = "pagina") page: Int = 1): CongressmanClientResponse

}
