package br.com.bumblebee.congressman.client

import br.com.bumblebee.congressman.client.model.ExpenseClientResponse
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.test.context.junit4.SpringRunner
import java.nio.file.Files.readAllBytes
import java.nio.file.Paths.get
import kotlin.test.assertEquals

@SpringBootTest
@RunWith(SpringRunner::class)
internal class ExpenseClientTest {

    private val EXPENSE_FIXTURE_PATH = "src/test/integration/resources/fixtures/expenses/congressman136811.json"
    private val EXPENSE_ENDPOINT = "/deputados/136811/despesas?.*"
    private val CONGRESSMAN_ID = 136811

    @Rule
    @JvmField
    final val wireMockRule = WireMockRule(9000)

    @Autowired
    private lateinit var client: ExpenseClient

    @Before
    fun setUp() {
        val expensesJson = String(readAllBytes(get(EXPENSE_FIXTURE_PATH)))

        givenThat(
            get(urlMatching(EXPENSE_ENDPOINT))
            .withQueryParam("pagina", equalTo("1"))
            .withHeader("Accept", equalTo(APPLICATION_JSON_UTF8_VALUE))
            .willReturn(okJson(expensesJson))
        )
    }

    @Test
    fun shouldGetListOfExpenses() {
        val congressmanExpenses: ExpenseClientResponse = client.getCongressmanExpenses(CONGRESSMAN_ID)

        verify(
            getRequestedFor(urlMatching(EXPENSE_ENDPOINT))
            .withHeader("Accept", equalTo(APPLICATION_JSON_UTF8_VALUE))
            .withQueryParam("pagina", equalTo("1"))
        )

        assertEquals(15, congressmanExpenses.expenses.size)
    }
}
