package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.ExpenseClient
import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.OpenDataResponse
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI


@Component
class ExpeseLinkNavigator(private val client: ExpenseClient): OpenDataLinkNavigator<ExpenseClientModel> {
    private val ID_INDEX = 3
    private val FALLBACK = "0"

    override fun navigate(uri: URI): OpenDataResponse<ExpenseClientModel> {
        val uriBuilder = UriComponentsBuilder.fromUri(uri).build()
        val nextPage: String = uriBuilder.queryParams.getOrDefault("pagina", listOf(FALLBACK)).first()
        val congressmanId: String = uriBuilder.pathSegments.getOrElse(ID_INDEX){ FALLBACK }
        return client.getCongressmanExpenses(congressmanId.toInt(), nextPage.toInt())
    }
}
