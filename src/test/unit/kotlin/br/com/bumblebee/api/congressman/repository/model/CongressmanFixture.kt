package br.com.bumblebee.api.congressman.repository.model

import java.time.LocalDate.now
import java.time.ZoneOffset
import java.util.Date

const val CONGRESSMAN_ID = 1000000
const val CONGRESSMAN_NAME = "Congressman Decepticon"
const val CONGRESSMAN_CPF = "12345678901"
const val CONGRESSMAN_GENDER = "M"
const val SCHOOLING = "High school"
const val SOCIAL_MEDIA = "Decepticon Facebook"
const val WEBSITE = "http://www.decepticon.com"
const val BIRTH_STATE = "CA"
const val BIRTH_CITY = "SF"

const val STATUS_ID = 1000000
const val ELECTION_NAME = "Not So Bad Decepticon"
const val ELECTION_CONDITION = "Elected"
const val LEGISLATURE_ID = 1000000
const val PARTY_ACRONYM = "PD"
const val STATE_ACRONYM = "CA"
const val STATUS = "Exercising"
const val PHOTO_URL = "http://www.decepticon.com/photo.jpg"

const val FLOOR = "2"
const val EMAIL = "deception@mail.com"
const val NAME = "Deception Office"
const val BUILDING = "2"
const val ROOM = "1"
const val PHONE = "4153201680"

val STATUS_DATE = Date()
val CONGRESSMAN_BIRTHDAY = Date.from(now().minusYears(40).atStartOfDay().toInstant(ZoneOffset.UTC))

val CONGRESSMAN_STATUS_FIXTURE = CongressmanStatus(
    STATUS_ID,
    ELECTION_NAME,
    ELECTION_CONDITION,
    STATUS_DATE,
    LEGISLATURE_ID,
    PARTY_ACRONYM,
    STATE_ACRONYM,
    STATUS,
    PHOTO_URL,
    null
)

val OFFICE_FIXTURE = Office(
    FLOOR,
    EMAIL,
    NAME,
    BUILDING,
    ROOM,
    PHONE
)

val CONGRESSMAN_FIXTURE = Congressman(
    CONGRESSMAN_ID,
    CONGRESSMAN_NAME,
    CONGRESSMAN_CPF,
    CONGRESSMAN_GENDER,
    CONGRESSMAN_BIRTHDAY,
    null,
    SCHOOLING,
    listOf(SOCIAL_MEDIA),
    WEBSITE,
    BIRTH_STATE,
    BIRTH_CITY,
    listOf(CONGRESSMAN_STATUS_FIXTURE),
    OFFICE_FIXTURE
)
