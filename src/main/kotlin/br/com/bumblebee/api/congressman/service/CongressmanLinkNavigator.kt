package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.CongressmanClient
import br.com.bumblebee.api.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class CongressmanLinkNavigator(private val client: CongressmanClient) : OpenDataLinkNavigator<CongressmanClientModel> {

    private companion object {
        private const val FALLBACK = "0"
    }

    override fun navigate(uri: URI): OpenDataResponse<CongressmanClientModel> {
        val uriBuilder = UriComponentsBuilder.fromUri(uri).build()
        val nextPage: String = uriBuilder.queryParams.getOrDefault("pagina", listOf(FALLBACK)).first()
        return client.getAll(nextPage.toInt())
    }
}
