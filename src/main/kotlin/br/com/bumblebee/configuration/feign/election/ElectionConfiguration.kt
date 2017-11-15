package br.com.bumblebee.configuration.feign.election

import br.com.bumblebee.configuration.feign.FeignConfiguration
import br.com.bumblebee.configuration.feign.election.decoder.ElectionDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ElectionConfiguration: FeignConfiguration() {

    @Bean
    fun electionDecoder() = ElectionDecoder()

}
