package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.model.EXPENSE_CLIENT_MODEL_FIXTURE
import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.Link
import br.com.bumblebee.congressman.client.model.LinkType
import br.com.bumblebee.congressman.client.model.OpenDataResponse
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.net.URL

internal class OpenDataIteratorTest {

    private lateinit var navigator: OpenDataLinkNavigator<ExpenseClientModel>

    @Before
    fun setUp() {
        navigator = mock()
    }

    @Test
    fun shouldImplementHasNext() {
        val iteratorWithoutNext = OpenDataIterator(responseWithoutNextElement, navigator)
        assertThat(iteratorWithoutNext.hasNext()).isFalse()

        val iteratorWithNext = OpenDataIterator(responseWithNextElement, navigator)
        assertThat(iteratorWithNext.hasNext()).isTrue()
    }

    @Test
    fun shouldCallNavigatorToGetNextItem() {
        whenever(navigator.navigate((any()))).thenReturn(eq(responseWithoutNextElement))
        val iterator = OpenDataIterator(responseWithNextElement, navigator)
        val next = iterator.next()

        verify(navigator).navigate(URL(nextLink.url))
        assertThat(next).isEqualTo(responseWithoutNextElement)
    }

    companion object {
        val responseWithoutNextElement = OpenDataResponse(listOf(EXPENSE_CLIENT_MODEL_FIXTURE))
        val nextLink = Link(LinkType.NEXT, "https://www.9gag.com")
        val responseWithNextElement = OpenDataResponse(
            listOf(EXPENSE_CLIENT_MODEL_FIXTURE),
            listOf(nextLink)
        )
    }
}
