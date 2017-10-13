package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.ExpenseClientResponse
import br.com.bumblebee.congressman.repository.model.Expense
import br.com.bumblebee.congressman.repository.model.Provider
import br.com.bumblebee.congressman.repository.model.Receipt

fun toExpenseResponse(response: ExpenseClientResponse) = response.expenses.map { toExpense(it) }

private fun toExpense(model: ExpenseClientModel): Expense =
    Expense(
        model.year,
        model.month,
        model.lotId,
        model.parcel,
        model.kind,
        model.netValue,
        createReceipt(model),
        model.refundNumber,
        model.glossValue,
        createProvider(model)
    )

private fun createReceipt(model: ExpenseClientModel): Receipt =
    Receipt(
        model.documentId,
        model.documentDate,
        model.documentKindId,
        model.documentNumber,
        model.documentUrl,
        model.documentValue,
        model.documentKind
    )

private fun createProvider(model: ExpenseClientModel): Provider =
    Provider(
        model.provider,
        model.providerId
    )
