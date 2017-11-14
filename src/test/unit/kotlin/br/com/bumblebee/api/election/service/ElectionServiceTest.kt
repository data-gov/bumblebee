package br.com.bumblebee.api.election.service

import br.com.bumblebee.api.election.client.ElectionClient
import br.com.bumblebee.api.election.client.model.PresidentElectionData
import br.com.bumblebee.configuration.environment.TEST
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@ActiveProfiles(TEST)
@RunWith(SpringRunner::class)
internal class ElectionServiceTest {

    @MockBean private lateinit var client: ElectionClient

    private lateinit var service: ElectionService
    private val electionYears = "1998, 2002, 2006, 2010, 2014"

    @Before
    fun setUp() {
        service = ElectionService(client)
    }

    @Test
    fun shouldExtractElectionInfo() {
        whenever(client.electionInfo(any(), any(), any(), any())).thenReturn(electionInfo())

        service.extractElectionInfo()

        verify(client).electionInfo(electionYears, 1)
    }

    private fun electionInfo() =
        listOf(PresidentElectionData(1, "PDG", 1, "PRESIDENTE", 2014, 99, "99", "RS", "VINICIUS", 100))
}
