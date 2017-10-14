package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.model.Link
import br.com.bumblebee.congressman.client.model.LinkType.NEXT
import br.com.bumblebee.congressman.client.model.OpenDataResponse
import java.net.URL

class OpenDataIterator<T>(private val iterable: OpenDataResponse<T>, private val navigator: OpenDataLinkNavigator<T>)
    : Iterator<OpenDataResponse<T>> {
    private val hasNextLink: (Link) -> Boolean = { it.type == NEXT }

    override fun hasNext(): Boolean {
        val nextLink = iterable.links.filter(hasNextLink)
        return !nextLink.isEmpty()
    }

    override fun next(): OpenDataResponse<T> {
        val next: Link? = iterable.links.find(hasNextLink)
        val url = URL(next?.url)
        return navigator.navigate(url)
    }
}
