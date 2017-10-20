package br.com.bumblebee.configuration.feign.decoder

import feign.Response
import feign.codec.ErrorDecoder
import mu.KotlinLogging
import java.lang.Exception

class FeignErrorDecoder : ErrorDecoder {
    private val logger = KotlinLogging.logger {}

    override fun decode(methodKey: String, response: Response): Exception {
        logger.error { errorMessage(methodKey, response) }
        return RuntimeException("External API failure")
    }

    private fun errorMessage(methodKey: String, response: Response): String {
        val responseBody = response.body().asReader()
        return "Error Status: ${response.status()}  Error body: $responseBody Executing: $methodKey"
    }

}
