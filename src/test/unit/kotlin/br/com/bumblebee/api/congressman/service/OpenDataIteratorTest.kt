package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.model.CONGRESSMAN_NEXT_LINK_FIXTURE
import br.com.bumblebee.api.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_CONGRESSMAN_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.net.URI

internal class OpenDataIteratorTest {

    private lateinit var navigator: OpenDataLinkNavigator<CongressmanClientModel>
    private val emptyResponse = OpenDataResponse<CongressmanClientModel>(emptyList())

    @Before
    fun setUp() {
        navigator = mock()
    }

    @Test
    fun shouldImplementHasNext() {
        val iteratorWithNext = OpenDataIterator(OPEN_DATA_CONGRESSMAN_FIXTURE, navigator)
        assertThat(iteratorWithNext.hasNext()).isTrue()

        val iteratorWithoutNext = OpenDataIterator(emptyResponse, navigator)
        assertThat(iteratorWithoutNext.hasNext()).isFalse()
    }

    @Test
    fun shouldCallNavigatorToGetNextItem() {
        whenever(navigator.navigate(any())).thenReturn(eq(OPEN_DATA_CONGRESSMAN_FIXTURE))
        val iterator = OpenDataIterator(OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE, navigator)

        assertThat(iterator.next()).isEqualTo(OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE)
        assertThat(iterator.next()).isEqualTo(OPEN_DATA_CONGRESSMAN_FIXTURE)
        assertThat(iterator.next()).isEqualTo(emptyResponse)
        verify(navigator).navigate(URI(CONGRESSMAN_NEXT_LINK_FIXTURE.url))
    }

}
