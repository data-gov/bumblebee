package br.com.bumblebee.api.election.controller

import br.com.bumblebee.api.election.service.ElectionService
import br.com.bumblebee.configuration.environment.TEST
import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(TEST)
@RunWith(SpringRunner::class)
internal class ElectionControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: ElectionService

    @Test
    fun shouldExtractElectionResults() {
        doNothing().whenever(service).extractElectionInfo()

        mockMvc.perform(get("/election"))
            .andExpect(status().isOk)
    }
}
