package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.model.Link
import br.com.bumblebee.api.congressman.client.model.LinkType.NEXT
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import java.net.URI

class OpenDataIterator<T>(iterable: OpenDataResponse<T>, private val navigator: OpenDataLinkNavigator<T>)
    : Iterator<OpenDataResponse<T>> {

    private var nextResponse: OpenDataResponse<T> = iterable

    override fun hasNext() = !nextResponse.data.isEmpty()

    override fun next(): OpenDataResponse<T> {
        val currentResponse = nextResponse
        nextResponse = updateNextResponse()
        return currentResponse
    }

    private fun updateNextResponse(): OpenDataResponse<T> {
        val next: Link? = nextResponse.links.find({ it.type == NEXT })
        return when (next) {
            null -> OpenDataResponse(emptyList())
            else -> navigator.navigate(URI(next.url))
        }
    }

}
