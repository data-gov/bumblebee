package br.com.bumblebee.congressman.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OpenDataResponse<T>(
    @JsonProperty("dados") val data: List<T>,
    @JsonProperty("links") val links: List<Link> = emptyList() // TODO: This should be a Map
    )

data class Link(
    @JsonProperty("rel") val type: LinkType,
    @JsonProperty("href") val url: String
    )

enum class LinkType {
    @JsonProperty("self") SELF,
    @JsonProperty("next") NEXT,
    @JsonProperty("first") FIRST,
    @JsonProperty("last") LAST,
    @JsonProperty("previous") PREVIOUS
}
