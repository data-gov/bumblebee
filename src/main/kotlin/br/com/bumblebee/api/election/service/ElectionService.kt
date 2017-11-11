package br.com.bumblebee.api.election.service

import br.com.bumblebee.api.election.client.ElectionClient
import org.springframework.stereotype.Service

@Service
class ElectionService(private val client: ElectionClient) {

    private companion object {
        private const val YEAR = 2014
        private const val ROLE_CODE = 1
    }

    fun getAllElectionInfo() {
        client.electionInfo(YEAR, ROLE_CODE)
    }
}
