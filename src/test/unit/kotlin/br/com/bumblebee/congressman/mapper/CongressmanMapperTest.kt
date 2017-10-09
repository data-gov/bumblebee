package br.com.bumblebee.congressman.mapper

import br.com.bumblebee.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.congressman.client.model.CongressmanClientResponse
import br.com.bumblebee.congressman.controller.model.CongressmanResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CongressmanMapperTest {

    @Test
    fun shouldTransformCongressmanClientResponseIntoCongressmanResponse() {
        val actual = toCongressmanResponse(CongressmanClientResponse(listOf(aCongressman())))
        val expected = listOf(CongressmanResponse(1, "Congressman Name", "PPP", "UF", "Photo URI"))

        assertEquals(actual, expected)
    }

    private fun aCongressman() = CongressmanClientModel(1, "URI", "Congressman Name", "PPP", "PPP URI", "UF", 1, "Photo URI")
}
