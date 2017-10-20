package br.com.bumblebee.api.congressman.mapper

import br.com.bumblebee.api.congressman.client.ExpenseClient
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_EXPENSE_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_EXPENSE_WITH_NEXT_FIXTURE
import br.com.bumblebee.api.congressman.repository.ExpenseRepository
import br.com.bumblebee.api.congressman.repository.model.Expense
import br.com.bumblebee.api.congressman.service.ExpenseService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
internal class ExpenseServiceTest {

    companion object {
        const val ID = 136811
        const val FIRST_PAGE = 1
        const val LAST_PAGE = 2
    }

    private lateinit var service: ExpenseService
    @MockBean private lateinit var client: ExpenseClient
    @MockBean private lateinit var repository: ExpenseRepository

    @Before
    fun setUp() {
        service = ExpenseService(client, repository)
    }

    @Test
    fun shouldSaveAllCongressmanExpenses() {
        whenever(client.getCongressmanExpenses(ID, FIRST_PAGE, ExpenseClient.ITEM))
            .thenReturn(OPEN_DATA_EXPENSE_WITH_NEXT_FIXTURE)
        whenever(client.getCongressmanExpenses(ID, LAST_PAGE, ExpenseClient.ITEM))
            .thenReturn(OPEN_DATA_EXPENSE_FIXTURE)

        service.saveAllCongressmanExpenses(ID)

        verify(client, times(2)).getCongressmanExpenses(eq(ID), any(), eq(ExpenseClient.ITEM))
        verify(repository, times(2)).saveAll(any<List<Expense>>())
    }

}
