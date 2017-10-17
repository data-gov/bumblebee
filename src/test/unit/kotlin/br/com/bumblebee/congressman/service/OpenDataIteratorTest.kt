package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.model.EXPENSE_NEXT_LINK_FIXTURE
import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.OPEN_DATA_EXPENSE_FIXTURE
import br.com.bumblebee.congressman.client.model.OPEN_DATA_EXPENSE_WITH_NEXT_FIXTURE
import br.com.bumblebee.congressman.client.model.OpenDataResponse
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

    private lateinit var navigator: OpenDataLinkNavigator<ExpenseClientModel>
    private val emptyResponse = OpenDataResponse<ExpenseClientModel>(emptyList())

    @Before
    fun setUp() {
        navigator = mock()
    }

    @Test
    fun shouldImplementHasNext() {
        val iteratorWithNext = OpenDataIterator(OPEN_DATA_EXPENSE_FIXTURE, navigator)
        assertThat(iteratorWithNext.hasNext()).isTrue()

        val iteratorWithoutNext = OpenDataIterator(emptyResponse, navigator)
        assertThat(iteratorWithoutNext.hasNext()).isFalse()
    }

    @Test
    fun shouldCallNavigatorToGetNextItem() {
        whenever(navigator.navigate(any())).thenReturn(eq(OPEN_DATA_EXPENSE_FIXTURE))
        val iterator = OpenDataIterator(OPEN_DATA_EXPENSE_WITH_NEXT_FIXTURE, navigator)

        assertThat(iterator.next()).isEqualTo(OPEN_DATA_EXPENSE_WITH_NEXT_FIXTURE)
        assertThat(iterator.next()).isEqualTo(OPEN_DATA_EXPENSE_FIXTURE)
        assertThat(iterator.next()).isEqualTo(emptyResponse)
        verify(navigator).navigate(URI(EXPENSE_NEXT_LINK_FIXTURE.url))
    }

}
