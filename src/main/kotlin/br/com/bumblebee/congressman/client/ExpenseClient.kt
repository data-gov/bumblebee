package br.com.bumblebee.congressman.client

import br.com.bumblebee.configuration.feign.FeignConfiguration
import br.com.bumblebee.congressman.client.model.ExpenseClientResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "expense", url = "\${camara.api}", configuration = arrayOf(FeignConfiguration::class))
@RequestMapping(produces = arrayOf(APPLICATION_JSON_UTF8_VALUE))
interface ExpenseClient {

    @GetMapping("deputados/{congressmanId}/despesas")
    fun getCongressmanExpenses(
        @PathVariable(name = "congressmanId") id: Int,
        @RequestParam(name = "pagina") page: Int = 1
    ): ExpenseClientResponse

}
