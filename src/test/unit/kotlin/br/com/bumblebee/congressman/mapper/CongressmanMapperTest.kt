package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.CONGRESSMAN_CLIENT_DETAILS_MODEL_FIXTURE
import br.com.bumblebee.congressman.repository.model.CONGRESSMAN_FIXTURE
import br.com.bumblebee.congressman.repository.model.EXPENSE_FIXTURE
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CongressmanMapperTest {

    @Test
    fun shouldTransformCongressmanClientResponseIntoCongressman() {
        val expected = CONGRESSMAN_FIXTURE
        val actual = toCongressman(CONGRESSMAN_CLIENT_DETAILS_MODEL_FIXTURE, listOf(EXPENSE_FIXTURE))
        assertThat(actual).isEqualTo(expected)
    }
}
