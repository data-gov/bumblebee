package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import java.net.URI

interface OpenDataLinkNavigator<T> {
    fun navigate(uri: URI): OpenDataResponse<T>
}
