package br.com.bumblebee.api.election.client

import br.com.bumblebee.configuration.feign.FeignConfiguration
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "election", url = "\${cepesp.api}", configuration = arrayOf(FeignConfiguration::class))
interface ElectionClient {

    @GetMapping(path = arrayOf("/tse"), produces = arrayOf("text/csv"))
    fun electionInfo(@RequestParam(name = "ano") year: Int, @RequestParam(name = "cargo") role: Int)
}
