package br.com.bumblebee.api.congressman.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

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

data class CongressmanDetailsClientResponse(
    @JsonProperty("dados") val congressmanDetails: CongressmanDetailsClientModel
)

data class CongressmanDetailsClientModel(
    val id: Int,
    val cpf: String,
    val uri: String,
    @JsonProperty("dataNascimento") val birthday: Date,
    @JsonProperty("dataFalecimento") val deathDate: Date?,
    @JsonProperty("escolaridade") val schooling: String?,
    @JsonProperty("redeSocial") val socialMedia: List<String>,
    @JsonProperty("sexo") val gender: String,
    @JsonProperty("urlWebsite") val websiteUrl: String?,
    @JsonProperty("ufNascimento") val birthState: String?,
    @JsonProperty("municipioNascimento") val birthCity: String,
    @JsonProperty("ultimoStatus") val lastStatus: CongressmanDetailsClientStatus
)

data class CongressmanDetailsClientStatus(
    val id: Int,
    val uri: String,
    @JsonProperty("condicaoEleitoral") val electionCondition: String,
    @JsonProperty("data") val date: Date,
    @JsonProperty("descricaoStatus") val description: String?,
    @JsonProperty("gabinete") val office: CongressmanDetailsClientOffice,
    @JsonProperty("idLegislatura") val legislatureId: Int,
    @JsonProperty("nome") val name: String,
    @JsonProperty("nomeEleitoral") val electionName: String,
    @JsonProperty("siglaPartido") val partyAcronym: String,
    @JsonProperty("siglaUf") val stateAcronym: String,
    @JsonProperty("situacao") val status: String,
    @JsonProperty("uriPartido") val partyUri: String,
    @JsonProperty("urlFoto") val photoUrl: String
)

data class CongressmanDetailsClientOffice(
    @JsonProperty("andar") val floor: String?,
    @JsonProperty("email") val email: String,
    @JsonProperty("nome") val name: String,
    @JsonProperty("predio") val building: String,
    @JsonProperty("sala") val room: String,
    @JsonProperty("telefone") val phone: String
)
