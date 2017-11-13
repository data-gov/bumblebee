package br.com.bumblebee.api.election.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PresidentElectionData(
    @JsonProperty("CODIGO_CARGO") val postCode: Int,
    @JsonProperty("SIGLA_PARTIDO") val partyAcronym: String,
    @JsonProperty("NUM_TURNO") val shift: Int,
    @JsonProperty("DESCRICAO_CARGO") val postDescription: String,
    @JsonProperty("ANO_ELEICAO") val electionYear: Int,
    @JsonProperty("NUMERO_PARTIDO") val partyNumber: Int,
    @JsonProperty("NUMERO_CANDIDATO") val candidateNumber: String,
    @JsonProperty("UF") val state: String,
    @JsonProperty("NOME_CANDIDATO") val candidateName: String,
    @JsonProperty("QTDE_VOTOS") val numberVotes: Int
)
