package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.congressman.client.model.CongressmanClientResponse
import br.com.bumblebee.congressman.controller.model.CongressmanResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CongressmanMapperTest {

    @Test
    fun shouldTransformCongressmanClientResponseIntoCongressmanResponse() {
        val actual = toCongressmanResponse(CongressmanClientResponse(listOf(aCongressman())))
        val expected = listOf(CongressmanResponse(1, "Congressman Name", "PPP", "UF", "Photo URI"))

        assertThat(actual).isEqualTo(expected)
    }

    private fun aCongressman() =
        CongressmanClientModel(1, "URI", "Congressman Name", "PPP", "PPP URI", "UF", 1, "Photo URI")
}
