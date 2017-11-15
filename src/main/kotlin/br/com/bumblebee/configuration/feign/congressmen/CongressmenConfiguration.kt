package br.com.bumblebee.configuration.feign.congressmen

import br.com.bumblebee.configuration.feign.FeignConfiguration
import com.fasterxml.jackson.databind.ObjectMapper
import feign.codec.Decoder
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder
import org.springframework.cloud.netflix.feign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@Configuration
class CongressmenConfiguration: FeignConfiguration() {

    @Bean
    fun congressmenDecoder(): Decoder {
        val jacksonConverter = MappingJackson2HttpMessageConverter(ObjectMapper())
        val objectFactory = { HttpMessageConverters(jacksonConverter) }
        return ResponseEntityDecoder(SpringDecoder(objectFactory))
    }

}
