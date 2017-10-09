package br.com.bumblebee.congressman.controller

import br.com.bumblebee.congressman.client.CongressmanClient
import br.com.bumblebee.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.congressman.client.model.CongressmanClientResponse
import com.nhaarman.mockito_kotlin.whenever
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@ExtendWith(SpringExtension::class)
@WebMvcTest(CongressmanController::class)
internal class CongressmanControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var client: CongressmanClient

    @Test
    fun shouldReturnListOfCongressman() {
        whenever(client.getAll()).thenReturn(CongressmanClientResponse(listOf(aCongressman())))

        mvc.perform(get("/congressman").accept(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)
            .andExpect(jsonPath("$", hasSize<Int>(1)))
    }

    private fun aCongressman() = CongressmanClientModel(1, "URI", "Congressman Name", "PPP", "PPP URI", "UF", 1, "Photo URI")
}
