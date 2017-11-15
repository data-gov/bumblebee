package br.com.bumblebee.api.congressman.client

import br.com.bumblebee.api.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.api.congressman.client.model.CongressmanDetailsClientResponse
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import br.com.bumblebee.configuration.feign.congressmen.CongressmenConfiguration
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "congressman", url = "\${camara.api}", configuration = arrayOf(CongressmenConfiguration::class))
interface CongressmanClient {

    private companion object {
        const val ITEMS = 100
    }

    @GetMapping(path = arrayOf("/deputados/{id}"), produces = arrayOf(APPLICATION_JSON_UTF8_VALUE))
    fun get(@PathVariable(name = "id") id: Int): CongressmanDetailsClientResponse

    @GetMapping(path = arrayOf("/deputados"), produces = arrayOf(APPLICATION_JSON_UTF8_VALUE))
    fun getAll(@RequestParam(name = "pagina") page: Int = 1,
               @RequestParam(name = "itens") items: Int = ITEMS
    ): OpenDataResponse<CongressmanClientModel>

}
