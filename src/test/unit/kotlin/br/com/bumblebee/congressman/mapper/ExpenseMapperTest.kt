package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.ExpenseClientResponse
import br.com.bumblebee.congressman.repository.model.Expense
import br.com.bumblebee.congressman.repository.model.Provider
import br.com.bumblebee.congressman.repository.model.Receipt
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.Date

internal class ExpenseMapperTest {

    @Test
    fun shouldTransformExpenseClientResponseIntoExpense() {
        val expected = listOf(Expense(YEAR, MONTH, LOT_ID, PARCEL, KIND, EXPENSE_ID, NET_VALUE, aReceipt(), REFUND_NUMBER, GLOSS_VALUE, aProvider()))
        val actual = toExpenseResponse(ExpenseClientResponse(listOf(aExpense())))

        assertThat(actual).isEqualTo(expected)
    }

    private companion object {
        private val RECEIPT_DATE = Date()
        private const val PROVIDER_NAME = "duduzinho do pagode"
        private const val PROVIDER_ID = "CPF/CNPJ"
        private const val URL = "www.xxx.yyy"
        private const val RECEIPT_KIND = "123"
        private const val RECEIPT_VALUE = 14.5f
        private const val RECEIPT_NUMBER = 23
        private const val RECEIPT_KIND_ID = 2
        private const val RECEIPT_ID = 0

        const val YEAR = 2017
        const val MONTH = 10
        const val KIND = "Nota Fiscal"
        const val NET_VALUE = 7.5f
        const val GLOSS_VALUE = 5.5f
        const val REFUND_NUMBER = 4
        const val LOT_ID = 2152
        const val PARCEL = 2
        const val EXPENSE_ID = 0

        fun aReceipt() = Receipt(RECEIPT_ID, RECEIPT_DATE, RECEIPT_KIND_ID, RECEIPT_NUMBER, URL, RECEIPT_VALUE, RECEIPT_KIND)
        fun aProvider() = Provider(PROVIDER_NAME, PROVIDER_ID)
        fun aExpense() = ExpenseClientModel(
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
    }
}
