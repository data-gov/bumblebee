package br.com.bumblebee.api.congressman.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "congressman")
data class Congressman(
    @Id val id: Int,
    val name: String,
    val cpf: String,
    val gender: String,
    val birthday: Date,
    val deathDate: Date?,
    val schooling: String?,
    val socialMedia: List<String>,
    val websiteUrl: String?,
    val birthState: String?,
    val birthCity: String,
    val status: List<CongressmanStatus>,
    val office: Office
)

data class CongressmanStatus(
    @Id val id: Int,
    val electionName: String,
    val electionCondition: String,
    val date: Date,
    val legislatureId: Int,
    val partyAcronym: String,
    val stateAcronym: String,
    val status: String,
    val photoUrl: String,
    val description: String?
)

data class Office(
    val floor: String?,
    val email: String,
    val name: String,
    val building: String,
    val room: String,
    val phone: String
)
