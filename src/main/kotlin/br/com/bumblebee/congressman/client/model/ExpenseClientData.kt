package br.com.bumblebee.congressman.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CongressmanClientResponse(@JsonProperty("dados") val congressman: List<CongressmanClientModel>)
data class CongressmanClientModel(
    val id: Int,
    val uri: String,
    @JsonProperty("nome") val name: String,
    @JsonProperty("siglaPartido") val partyAcronym: String,
    @JsonProperty("uriPartido") val partyUri: String,
    @JsonProperty("siglaUf") val stateAcronym: String,
    @JsonProperty("idLegislatura") val legislatureId: Int,
    @JsonProperty("urlFoto") val photoUrl: String
)
