package br.com.bumblebee.configuration.feign

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration {

    @Bean
    fun logger(): Logger.Level {
        return Logger.Level.FULL
    }
}
