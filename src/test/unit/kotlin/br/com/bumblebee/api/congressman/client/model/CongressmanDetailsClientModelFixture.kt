package br.com.bumblebee.api.congressman.client.model

import br.com.bumblebee.api.congressman.repository.model.*

const val CONGRESSMAN_URI = "https://dadosabertos.camara.leg.br/api/v2/deputados/1000000"
const val PARTY_URI = "https://dadosabertos.camara.leg.br/api/v2/partido/100"

private val CONGRESSMAN_DETAILS_CLIENT_OFFICE_FIXTURE = CongressmanDetailsClientOffice(
    FLOOR,
    EMAIL,
    NAME,
    BUILDING,
    ROOM,
    PHONE
)

private val CONGRESSMAN_CLIENT_DETAILS_STATUS_FIXTURE = CongressmanDetailsClientStatus(
    STATUS_ID,
    CONGRESSMAN_URI,
    ELECTION_CONDITION,
    STATUS_DATE,
    null,
    CONGRESSMAN_DETAILS_CLIENT_OFFICE_FIXTURE,
    LEGISLATURE_ID,
    CONGRESSMAN_NAME,
    ELECTION_NAME,
    PARTY_ACRONYM,
    STATE_ACRONYM,
    STATUS,
    PARTY_URI,
    PHOTO_URL
)

val CONGRESSMAN_CLIENT_DETAILS_MODEL_FIXTURE = CongressmanDetailsClientModel(
    CONGRESSMAN_ID,
    CONGRESSMAN_CPF,
    CONGRESSMAN_URI,
    CONGRESSMAN_BIRTHDAY,
    null,
    SCHOOLING,
    listOf(SOCIAL_MEDIA),
    CONGRESSMAN_GENDER,
    WEBSITE,
    BIRTH_STATE,
    BIRTH_CITY,
    CONGRESSMAN_CLIENT_DETAILS_STATUS_FIXTURE
)

val CONGRESSMAN_DETAILS_CLIENT_RESPONSE_FIXTURE = CongressmanDetailsClientResponse(
    CONGRESSMAN_CLIENT_DETAILS_MODEL_FIXTURE
)
