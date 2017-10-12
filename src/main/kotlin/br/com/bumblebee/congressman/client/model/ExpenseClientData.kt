package br.com.bumblebee.congressman.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class ExpenseClientResponse(@JsonProperty("dados") val expenses: List<ExpenseClientModel>)

data class ExpenseClientModel(
    @JsonProperty("ano") val year: Int,
    @JsonProperty("mes") val month: Int,
    @JsonProperty("tipoDespesa") val kind: String,
    @JsonProperty("idDocumento") val documentId: Int,
    @JsonProperty("tipoDocumento") val documentKind: String,
    @JsonProperty("idTipoDocumento") val documentKindId: Int,
    @JsonProperty("dataDocumento") val documentDate: Date,
    @JsonProperty("numDocumento") val documentNumber: Int,
    @JsonProperty("valorDocumento") val documentValue: Float,
    @JsonProperty("urlDocumento") val documentUrl: String,
    @JsonProperty("nomeFornecedor") val provider: String,
    @JsonProperty("cnpjCpfFornecedor") val providerId: String,
    @JsonProperty("valorLiquido") val netValue: Float,
    @JsonProperty("valorGlosa") val glossValue: Float,
    @JsonProperty("numRessarcimento") val refundNumber: Int,
    @JsonProperty("idLote") val lotId: String,
    @JsonProperty("parcela") val parcel: String
)
