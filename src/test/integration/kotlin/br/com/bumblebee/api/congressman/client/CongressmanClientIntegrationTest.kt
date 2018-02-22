package br.com.bumblebee.api.congressman.client

import br.com.bumblebee.configuration.environment.INTEGRATION
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.givenThat
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.nio.charset.Charset
import java.nio.file.Files.readAllBytes
import java.nio.file.Paths

@ActiveProfiles(INTEGRATION)
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
internal class CongressmanClientIntegrationTest {

    companion object {
        const val CONGRESSMAN_ENDPOINT_FIXTURE_PATH = "src/test/integration/resources/fixtures/congressman/congressman.json"
        const val CONGRESSMAN_ENDPOINT = "/deputados?pagina=1&itens=100"
        const val WIREMOCK_PORT = 9000
        const val PAGE = 1
        const val ITEMS = 100
    }

    @get:Rule
    val wireMockRule = WireMockRule(WIREMOCK_PORT)

    @Autowired
    private lateinit var client: CongressmanClient

    @Test
    @Ignore
    fun shouldGetAllCongressman() {
        val expensesJson = readAllBytes(Paths.get(CONGRESSMAN_ENDPOINT_FIXTURE_PATH)).toString(Charset.defaultCharset())
        givenThat(
            get(urlMatching(CONGRESSMAN_ENDPOINT))
                .withQueryParam("pagina", equalTo("1"))
                .withQueryParam("itens", equalTo("100"))
                .withHeader("Accept", equalTo(APPLICATION_JSON_UTF8_VALUE))
                .willReturn(okJson(expensesJson))
        )

        val allCongressman = client.getAll(PAGE, ITEMS)

        verify(
            getRequestedFor(urlMatching(CONGRESSMAN_ENDPOINT))
                .withHeader("Accept", equalTo(APPLICATION_JSON_UTF8_VALUE))
                .withQueryParam("pagina", equalTo("1"))
        )

        assertThat(allCongressman.data.size).isEqualTo(3)

    }
}
