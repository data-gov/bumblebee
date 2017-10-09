package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.congressman.client.model.CongressmanClientResponse
import br.com.bumblebee.congressman.controller.model.CongressmanResponse

fun toCongressmanResponse(clientResponse: CongressmanClientResponse) =
    clientResponse.congressman.map { toCongressman(it) }

private fun toCongressman(model: CongressmanClientModel) =
    CongressmanResponse(model.id, model.name, model.partyAcronym, model.stateAcronym, model.photoUrl)

