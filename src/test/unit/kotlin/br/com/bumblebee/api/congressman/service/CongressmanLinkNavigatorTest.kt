package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.CongressmanClient
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_CONGRESSMAN_FIXTURE
import br.com.bumblebee.api.congressman.service.navigator.CongressmanLinkNavigator
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.net.URI

@ExtendWith(SpringExtension::class)
internal class CongressmanLinkNavigatorTest {
    private companion object {
        const val NEXT_PAGE = 2
    }

    @MockBean
    private lateinit var client: CongressmanClient
    private lateinit var navigator: CongressmanLinkNavigator

    @BeforeEach
    fun setUp() {
        whenever(client.getAll(page = NEXT_PAGE)).thenReturn(OPEN_DATA_CONGRESSMAN_FIXTURE)
        navigator = CongressmanLinkNavigator(client)
    }

    @Test
    fun shouldCallNextLinkAndReturnMappedResponse() {
        val uri = URI("https://dadosabertos.camara.leg.br/api/v2/deputados?pagina=$NEXT_PAGE&itens=100")
        val nextResponse = navigator.navigate(uri)

        verify(client).getAll(page = NEXT_PAGE)
        assertThat(nextResponse).isEqualTo(OPEN_DATA_CONGRESSMAN_FIXTURE)
    }

}
