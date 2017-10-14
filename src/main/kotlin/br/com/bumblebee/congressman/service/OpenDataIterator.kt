package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.model.Link
import br.com.bumblebee.congressman.client.model.LinkType.NEXT
import br.com.bumblebee.congressman.client.model.OpenDataResponse

class OpenDataIterator<T>(private val iterable: OpenDataResponse<T>, private val navigator: OpenDataLinkNavigator<T>)
    : Iterator<OpenDataResponse<T>> {
    private val hasNextLink: (Link) -> Boolean = { it.type == NEXT }

    override fun hasNext(): Boolean {
        val nextLink = iterable.links.filter(hasNextLink)
        return !nextLink.isEmpty()
    }

    override fun next(): OpenDataResponse<T> {
        val next = iterable.links.find(hasNextLink)
        return navigator.navigate(next!!.url)
    }
}
