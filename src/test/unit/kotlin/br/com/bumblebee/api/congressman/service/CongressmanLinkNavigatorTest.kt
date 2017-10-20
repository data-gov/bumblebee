package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.CongressmanClient
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_CONGRESSMAN_FIXTURE
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
internal class CongressmanLinkNavigatorTest {
    private companion object {
        const val NEXT_PAGE = 2
    }

    @MockBean
    private lateinit var client: CongressmanClient
    private lateinit var navigator: CongressmanLinkNavigator

    @Before
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
