package br.com.bumblebee.configuration.jackson

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class JacksonConfiguration {

    @Bean
    fun objectMapperBuilder() = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())
}
