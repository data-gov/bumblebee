package br.com.bumblebee.configuration.feign

import feign.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration {

    @Value("\${logging.feign.type}")
    lateinit var loggerType: String

    @Bean
    fun logger(): Logger.Level {
        return Logger.Level.valueOf(loggerType)
    }
}
