package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.CongressmanDetailsClientModel
import br.com.bumblebee.congressman.client.model.CongressmanDetailsClientOffice
import br.com.bumblebee.congressman.client.model.CongressmanDetailsClientStatus
import br.com.bumblebee.congressman.repository.model.Congressman
import br.com.bumblebee.congressman.repository.model.CongressmanStatus
import br.com.bumblebee.congressman.repository.model.Expense
import br.com.bumblebee.congressman.repository.model.Office

fun toCongressman(congressman: CongressmanDetailsClientModel, expenses: List<Expense>) =
    Congressman(
        congressman.id,
        congressman.lastStatus.name,
        congressman.cpf, congressman.gender,
        congressman.birthday,
        congressman.deathDate,
        congressman.schooling,
        congressman.socialMedia,
        congressman.websiteUrl ,
        congressman.birthState,
        congressman.birthCity,
        createStatus(congressman.lastStatus),
        creteOffice(congressman.lastStatus.office),
        expenses
    )

private fun createStatus(status: CongressmanDetailsClientStatus) =
    listOf(CongressmanStatus(
        status.id,
        status.electionName,
        status.electionCondition,
        status.date,
        status.legislatureId,
        status.partyAcronym,
        status.stateAcronym,
        status.status,
        status.photoUrl,
        status.description)
    )

private fun creteOffice(office: CongressmanDetailsClientOffice) =
    Office(
        office.floor ,
        office.email,
        office.name,
        office.building,
        office.room,
        office.phone)

