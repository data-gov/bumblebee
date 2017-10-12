package br.com.bumblebee.congressman.client

import br.com.bumblebee.configuration.environment.INTEGRATION
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.givenThat
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.nio.file.Files.readAllBytes
import java.nio.file.Paths
import kotlin.test.assertEquals

@ActiveProfiles(INTEGRATION)
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
internal class ExpenseClientTest {

    companion object {
        const val EXPENSE_FIXTURE_PATH = "src/test/integration/resources/fixtures/expenses/congressman136811.json"
        const val EXPENSE_ENDPOINT = "/deputados/136811/despesas?.*"
        const val CONGRESSMAN_ID = 136811
        const val WIREMOCK_PORT = 9000
        const val EXPECTED_EXPENSES_SIZE = 15
    }

    @get:Rule
    val wireMockRule = WireMockRule(WIREMOCK_PORT)

    @Autowired
    private lateinit var client: ExpenseClient

    @Before
    fun setUp() {
        val expensesJson = String(readAllBytes(Paths.get(EXPENSE_FIXTURE_PATH)))

        givenThat(
            get(urlMatching(EXPENSE_ENDPOINT))
            .withQueryParam("pagina", equalTo("1"))
            .withHeader("Accept", equalTo(APPLICATION_JSON_UTF8_VALUE))
            .willReturn(okJson(expensesJson))
        )
    }

    @Test
    fun shouldGetListOfExpenses() {
        val congressmanExpenses = client.getCongressmanExpenses(CONGRESSMAN_ID)

        verify(
            getRequestedFor(urlMatching(EXPENSE_ENDPOINT))
            .withHeader("Accept", equalTo(APPLICATION_JSON_UTF8_VALUE))
            .withQueryParam("pagina", equalTo("1"))
        )

        assertEquals(EXPECTED_EXPENSES_SIZE, congressmanExpenses.expenses.size)
    }
}
