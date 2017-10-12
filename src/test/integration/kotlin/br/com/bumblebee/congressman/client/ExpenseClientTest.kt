package br.com.bumblebee.congressman.client

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@SpringBootTest
@RunWith(SpringRunner::class)
internal class ExpenseClientTest {

    private val EXPENSE_ENDPOINT = "deputados/([0-9]+)/despesas"
    private val CONGRESSMAN_ID = 136811

    @Rule
    @JvmField
    final val wireMockRule = WireMockRule(wireMockConfig().port(9000))

    @Autowired
    private lateinit var client: ExpenseClient

    @Test
    fun shouldGetListOfExpenses() {
        givenThat(post(urlPathMatching(EXPENSE_ENDPOINT))
            .withHeader("Content-Type", equalTo(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .willReturn(okJson("dados: []")))

        val congressmanExpenses = client.getCongressmanExpenses(CONGRESSMAN_ID)
        println(congressmanExpenses)

        assertEquals(true, false)

    }
}
