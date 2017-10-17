package br.com.bumblebee.configuration.feign

import br.com.bumblebee.congressman.client.decoder.FeignErrorDecoder
import feign.Logger
import feign.Request
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class FeignConfiguration {

    private companion object {
        const val MAX_CONNECTIONS = 10
        const val DURATION: Long = 5
    }

    @Value("\${logging.feign.type}")
    private lateinit var loggerType: String

    @Value("\${feign.readTimeout}")
    private lateinit var readTimeout: String

    @Value("\${feign.connectTimeout}")
    private lateinit var connectTimeout: String

    @Bean
    fun logger() = Logger.Level.valueOf(loggerType)

    @Bean
    fun options() = Request.Options(connectTimeout.toInt(), readTimeout.toInt())

    @Bean
    fun errorDecoder() = FeignErrorDecoder()

    @Bean
    fun okHttpClient(): feign.okhttp.OkHttpClient {
        return feign.okhttp.OkHttpClient(OkHttpClient.Builder()
            .connectionPool(ConnectionPool(MAX_CONNECTIONS, DURATION, TimeUnit.MINUTES))
            .readTimeout(readTimeout.toLong(), TimeUnit.MILLISECONDS)
            .connectTimeout(connectTimeout.toLong(), TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build())
    }
}
