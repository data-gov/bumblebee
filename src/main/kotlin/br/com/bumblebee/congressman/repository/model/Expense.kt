package br.com.bumblebee.congressman.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document(collection = "expenses")
data class Expense(
    val year: Int,
    val month: Int,
    val lotId: Int,
    val parcel: Int,
    val kind: String,
    val netValue: Float,
    val receipt: Receipt,
    val refundNumber: Int,
    val glossValue: Float,
    val provider: Provider
)

@Document(collection = "expenses")
data class Receipt(
    @Id val id: Int,
    val date: Date?,
    val kindId: Int,
    val number: String,
    val url: String,
    val value: Float,
    val kind: String
)

@Document(collection = "expenses")
data class Provider(
    val name: String,
    @Id val id: String
)
