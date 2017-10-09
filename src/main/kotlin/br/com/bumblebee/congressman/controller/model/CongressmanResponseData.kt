package br.com.bumblebee.congressman.controller.model

data class CongressmanResponse(
    val id: Int,
    val name: String,
    val partyAcronym: String,
    val stateAcronym: String,
    val photoUrl: String
)
