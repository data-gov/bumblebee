package br.com.bumblebee.congressman.client.model

import br.com.bumblebee.congressman.client.model.LinkType.NEXT

val NEXT_LINK_FIXTURE = Link(NEXT,
    "https://dadosabertos.camara.leg.br/api/v2/deputados/136811/despesas?pagina=2&itens=15")
val OPEN_DATA_EXPENSE_FIXTURE = OpenDataResponse(listOf(EXPENSE_CLIENT_MODEL_FIXTURE))
val OPEN_DATA_EXPENSE_WITH_NEXT_FIXTURE = OpenDataResponse(
    listOf(EXPENSE_CLIENT_MODEL_FIXTURE),
    listOf(NEXT_LINK_FIXTURE)
)
