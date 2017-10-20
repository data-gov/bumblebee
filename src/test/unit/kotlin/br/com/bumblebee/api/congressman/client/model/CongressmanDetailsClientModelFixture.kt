package br.com.bumblebee.api.congressman.client.model

import br.com.bumblebee.api.congressman.repository.model.BIRTH_CITY
import br.com.bumblebee.api.congressman.repository.model.BIRTH_STATE
import br.com.bumblebee.api.congressman.repository.model.BUILDING
import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_BIRTHDAY
import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_CPF
import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_GENDER
import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_ID
import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_NAME
import br.com.bumblebee.api.congressman.repository.model.ELECTION_CONDITION
import br.com.bumblebee.api.congressman.repository.model.ELECTION_NAME
import br.com.bumblebee.api.congressman.repository.model.EMAIL
import br.com.bumblebee.api.congressman.repository.model.FLOOR
import br.com.bumblebee.api.congressman.repository.model.LEGISLATURE_ID
import br.com.bumblebee.api.congressman.repository.model.NAME
import br.com.bumblebee.api.congressman.repository.model.PARTY_ACRONYM
import br.com.bumblebee.api.congressman.repository.model.PHONE
import br.com.bumblebee.api.congressman.repository.model.PHOTO_URL
import br.com.bumblebee.api.congressman.repository.model.ROOM
import br.com.bumblebee.api.congressman.repository.model.SCHOOLING
import br.com.bumblebee.api.congressman.repository.model.SOCIAL_MEDIA
import br.com.bumblebee.api.congressman.repository.model.STATE_ACRONYM
import br.com.bumblebee.api.congressman.repository.model.STATUS
import br.com.bumblebee.api.congressman.repository.model.STATUS_DATE
import br.com.bumblebee.api.congressman.repository.model.STATUS_ID
import br.com.bumblebee.api.congressman.repository.model.WEBSITE

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
