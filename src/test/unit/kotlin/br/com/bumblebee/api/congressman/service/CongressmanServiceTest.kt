package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.CongressmanClient
import br.com.bumblebee.api.congressman.client.model.CONGRESSMAN_DETAILS_CLIENT_RESPONSE_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import br.com.bumblebee.api.congressman.repository.CongressmanRepository
import br.com.bumblebee.api.congressman.repository.model.EXPENSE_FIXTURE
import com.google.common.collect.ImmutableList.copyOf
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
internal class CongressmanServiceTest {

    companion object {
        const val ID = 1000000
        const val ITEMS = 100
    }

    @MockBean private lateinit var client: CongressmanClient
    @MockBean private lateinit var repository: CongressmanRepository
    @MockBean private lateinit var expenseService: ExpenseService

    private lateinit var service: CongressmanService

    @Before
    fun setUp() {
        service = CongressmanService(client, repository, expenseService)
    }

    @Test
    fun shouldSaveAllCongressman() {
        whenever(client.getAll()).thenReturn(OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE)
        whenever(client.getAll(page = 2)).thenReturn(OpenDataResponse(emptyList(), emptyList()))
        whenever(client.get(ID)).thenReturn(CONGRESSMAN_DETAILS_CLIENT_RESPONSE_FIXTURE)
        whenever(expenseService.getAllCongressmanExpenses(ID)).thenReturn(copyOf(listOf(EXPENSE_FIXTURE)))

        val allCongressman = service.saveAllCongressman()

        verify(client, times(2)).getAll(any(), any())
        verify(expenseService, times(1)).getAllCongressmanExpenses(ID)

        assertThat(allCongressman).hasSize(1)
    }
}
