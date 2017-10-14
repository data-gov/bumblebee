package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.ExpenseClient
import br.com.bumblebee.congressman.client.model.EXPENSE_CLIENT_MODEL_FIXTURE
import br.com.bumblebee.congressman.client.model.OpenDataResponse
import br.com.bumblebee.congressman.repository.ExpenseRepository
import br.com.bumblebee.congressman.repository.model.Expense
import br.com.bumblebee.congressman.service.ExpenseService
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
internal class ExpenseServiceTest {

    companion object {
        const val ID = 666
    }

    private lateinit var service: ExpenseService
    @MockBean private lateinit var client: ExpenseClient
    @MockBean private lateinit var repository: ExpenseRepository

    @Before
    fun setUp() {
        service = ExpenseService(client, repository)
    }

    @Test
    fun shouldTransformExpenseClientResponseIntoExpense() {
        val mappedResponses: List<Expense> = toExpenses(listOf(EXPENSE_CLIENT_MODEL_FIXTURE))
        whenever(client.getCongressmanExpenses(ID)).thenReturn(OpenDataResponse(listOf(EXPENSE_CLIENT_MODEL_FIXTURE)))
        whenever(repository.saveAll(mappedResponses)).thenReturn(mappedResponses)

        val saveCongressmanExpenses = service.saveCongressmanExpenses(ID)

        verify(client).getCongressmanExpenses(ID)
        verify(repository).saveAll(mappedResponses)
        assertThat(mappedResponses).isEqualTo(saveCongressmanExpenses)
    }

}
