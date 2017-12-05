package br.com.bumblebee.api.election.client

import br.com.bumblebee.api.election.client.model.PresidentElectionData
import br.com.bumblebee.configuration.feign.election.ElectionConfiguration
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "election", url = "\${cepesp.api}", configuration = arrayOf(ElectionConfiguration::class))
interface ElectionClient {

    @GetMapping(path = arrayOf("/tse"))
    fun electionInfo(@RequestParam(name = "ano") year: String,
                     @RequestParam(name = "cargo") role: Int,
                     @RequestParam(name = "agregacao_regional") regionalAggregation: Int = 2,
                     @RequestParam(name = "agregacao_politica") politicalAggregation: Int = 2):
        List<PresidentElectionData>
}
