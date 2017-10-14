package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.model.OpenDataResponse
import java.net.URI

interface OpenDataLinkNavigator<T> {
    fun navigate(url: URI): OpenDataResponse<T>
}
