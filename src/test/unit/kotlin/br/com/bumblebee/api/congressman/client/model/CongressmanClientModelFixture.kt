package br.com.bumblebee.api.congressman.client.model

import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_ID
import br.com.bumblebee.api.congressman.repository.model.CONGRESSMAN_NAME
import br.com.bumblebee.api.congressman.repository.model.LEGISLATURE_ID
import br.com.bumblebee.api.congressman.repository.model.PARTY_ACRONYM
import br.com.bumblebee.api.congressman.repository.model.PHOTO_URL
import br.com.bumblebee.api.congressman.repository.model.STATE_ACRONYM

val CONGRESSMAN_CLIENT_MODEL_FIXTURE = CongressmanClientModel(
    CONGRESSMAN_ID,
    CONGRESSMAN_URI,
    CONGRESSMAN_NAME,
    PARTY_ACRONYM,
    PARTY_URI,
    STATE_ACRONYM,
    LEGISLATURE_ID,
    PHOTO_URL
)
