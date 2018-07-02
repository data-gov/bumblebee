package br.com.bumblebee.api.congressman.client.model

import br.com.bumblebee.api.congressman.client.model.LinkType.NEXT

val CONGRESSMAN_NEXT_LINK_FIXTURE = Link(NEXT,
    "https://dadosabertos.camara.leg.br/api/v2/deputados?pagina=2&itens=100")

val OPEN_DATA_CONGRESSMAN_FIXTURE = OpenDataResponse(listOf(CONGRESSMAN_CLIENT_MODEL_FIXTURE))

val OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE = OpenDataResponse(
    listOf(CONGRESSMAN_CLIENT_MODEL_FIXTURE),
    listOf(CONGRESSMAN_NEXT_LINK_FIXTURE)
)
