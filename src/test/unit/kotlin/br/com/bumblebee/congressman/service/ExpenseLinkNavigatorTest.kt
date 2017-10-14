package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.ExpenseClient
import br.com.bumblebee.congressman.client.model.OPEN_DATA_EXPENSE_FIXTURE
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.net.URI

@RunWith(SpringRunner::class)
internal class ExpenseLinkNavigatorTest {
    companion object {
        const val ID = 666
        const val NEXT_PAGE = 2
    }

    private lateinit var navigator: ExpenseLinkNavigator
    @MockBean private lateinit var client: ExpenseClient

    @Before
    fun setUp() {
        whenever(client.getCongressmanExpenses(ID, NEXT_PAGE)).thenReturn(OPEN_DATA_EXPENSE_FIXTURE)
        navigator = ExpenseLinkNavigator(client)
    }

    @Test
    fun shouldCallNextLinkAndReturnMappedRespose() {
        val uri = URI("https://dadosabertos.camara.leg.br/api/v2/deputados/$ID/despesas?pagina=$NEXT_PAGE&itens=15")
        val nextResponse = navigator.navigate(uri)
        verify(client).getCongressmanExpenses(ID, NEXT_PAGE)
        assertThat(nextResponse).isEqualTo(OPEN_DATA_EXPENSE_FIXTURE)
    }

}
