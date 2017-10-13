package br.com.bumblebee.congressman.repository.model

import java.util.Date

val RECEIPT_DATE = Date()
const val PROVIDER_NAME = "duduzinho do pagode"
const val PROVIDER_ID = "CPF/CNPJ"
const val URL = "www.xxx.yyy"
const val RECEIPT_KIND = "123"
const val RECEIPT_VALUE = 14.5f
const val RECEIPT_NUMBER = 23
const val RECEIPT_KIND_ID = 2
const val RECEIPT_ID = 0

const val YEAR = 2017
const val MONTH = 10
const val KIND = "Nota Fiscal"
const val NET_VALUE = 7.5f
const val GLOSS_VALUE = 5.5f
const val REFUND_NUMBER = 4
const val LOT_ID = 2152
const val PARCEL = 2

val PROVIDER_FIXTURE = Provider(PROVIDER_NAME, PROVIDER_ID)
val RECEIPT_FIXTURE = Receipt(
    RECEIPT_ID,
    RECEIPT_DATE,
    RECEIPT_KIND_ID,
    RECEIPT_NUMBER,
    URL,
    RECEIPT_VALUE,
    RECEIPT_KIND
)
val EXPENSE_FIXTURE = Expense(
    YEAR,
    MONTH,
    LOT_ID,
    PARCEL,
    KIND,
    NET_VALUE,
    RECEIPT_FIXTURE,
    REFUND_NUMBER,
    GLOSS_VALUE,
    PROVIDER_FIXTURE
)
