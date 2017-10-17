package br.com.bumblebee.congressman.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "congressman")
data class Congressman(
    @Id val id: Int,
    val name: String,
    val partyAcronym: String,
    val partyUri: String,
    val stateAcronym: String,
    val legislatureId: Int,
    val photoUrl: String
)
