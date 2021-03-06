package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.CongressmanClient
import br.com.bumblebee.api.congressman.client.model.CONGRESSMAN_DETAILS_CLIENT_RESPONSE_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import br.com.bumblebee.api.congressman.repository.CongressmanRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
internal class CongressmanServiceTest {

    companion object {
        const val ID = 1000000
    }

    @MockBean
    private lateinit var client: CongressmanClient

    @MockBean
    private lateinit var repository: CongressmanRepository

    private lateinit var service: CongressmanService

    @BeforeEach
    fun setUp() {
        service = CongressmanService(client, repository)
    }

    @Test
    fun shouldSaveAllCongressman() {
        whenever(client.getAll()).thenReturn(OPEN_DATA_CONGRESSMAN_WITH_NEXT_FIXTURE)
        whenever(client.getAll(page = 2)).thenReturn(OpenDataResponse(emptyList(), emptyList()))
        whenever(client.get(ID)).thenReturn(CONGRESSMAN_DETAILS_CLIENT_RESPONSE_FIXTURE)

        service.saveAllCongressman()

        verify(client, times(2)).getAll(any(), any())

//        assertThat(allCongressman).hasSize(1)
    }
}
