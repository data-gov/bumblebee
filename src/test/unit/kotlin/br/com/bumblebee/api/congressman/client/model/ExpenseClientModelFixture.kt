package br.com.bumblebee.api.congressman.client.model

import br.com.bumblebee.api.congressman.repository.model.GLOSS_VALUE
import br.com.bumblebee.api.congressman.repository.model.KIND
import br.com.bumblebee.api.congressman.repository.model.LOT_ID
import br.com.bumblebee.api.congressman.repository.model.MONTH
import br.com.bumblebee.api.congressman.repository.model.NET_VALUE
import br.com.bumblebee.api.congressman.repository.model.PARCEL
import br.com.bumblebee.api.congressman.repository.model.PROVIDER_ID
import br.com.bumblebee.api.congressman.repository.model.PROVIDER_NAME
import br.com.bumblebee.api.congressman.repository.model.RECEIPT_DATE
import br.com.bumblebee.api.congressman.repository.model.RECEIPT_ID
import br.com.bumblebee.api.congressman.repository.model.RECEIPT_KIND
import br.com.bumblebee.api.congressman.repository.model.RECEIPT_KIND_ID
import br.com.bumblebee.api.congressman.repository.model.RECEIPT_NUMBER
import br.com.bumblebee.api.congressman.repository.model.RECEIPT_VALUE
import br.com.bumblebee.api.congressman.repository.model.REFUND_NUMBER
import br.com.bumblebee.api.congressman.repository.model.URL
import br.com.bumblebee.api.congressman.repository.model.YEAR

val EXPENSE_CLIENT_MODEL_FIXTURE = ExpenseClientModel(
    YEAR,
    MONTH,
    KIND,
    RECEIPT_ID,
    RECEIPT_KIND,
    RECEIPT_KIND_ID,
    RECEIPT_DATE,
    RECEIPT_NUMBER,
    RECEIPT_VALUE,
    URL,
    PROVIDER_NAME,
    PROVIDER_ID,
    NET_VALUE,
    GLOSS_VALUE,
    REFUND_NUMBER,
    LOT_ID,
    PARCEL
)
