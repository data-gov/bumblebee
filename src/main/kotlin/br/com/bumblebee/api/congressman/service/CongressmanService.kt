package br.com.bumblebee.api.congressman.service

import br.com.bumblebee.api.congressman.client.CongressmanClient
import br.com.bumblebee.api.congressman.client.model.CongressmanClientModel
import br.com.bumblebee.api.congressman.client.model.OpenDataResponse
import br.com.bumblebee.api.congressman.mapper.toCongressman
import br.com.bumblebee.api.congressman.repository.CongressmanRepository
import br.com.bumblebee.api.congressman.repository.model.Congressman
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableList.copyOf
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CongressmanService(private val client: CongressmanClient,
                         private val repository: CongressmanRepository,
                         private val expenseService: ExpenseService) {

    private val logger = KotlinLogging.logger {}

    fun saveAllCongressman(): ImmutableList<Congressman> {
        val congressmanWithDetails = allCongressman()
            .map { congressmanDetails(it.id) }

        logger.info { "Congressman extraction finished. " }

        return copyOf(congressmanWithDetails)
    }

    /**
     *
     * Extract all congresmman from API and save in our database
     * @return the saved list.
     *
     * @deprecated will be merged with saveAllCongressman
     */
    fun saveAllCongressmanInRepository(): ImmutableList<Congressman> {
        val congressmanWithDetails = allCongressman()
            .map { congressmanDetails(it.id) }

        logger.info { "Congressman extraction finished. " }

        return copyOf(repository.saveAll(congressmanWithDetails))
    }

    private fun allCongressman(): ImmutableList<CongressmanClientModel> {
        val congressmanList = mutableListOf<CongressmanClientModel>()

        logger.info { " Start fetching congressman list. " }

        client.getAll()
            .iterator()
            .forEach { it -> congressmanList.addAll(it.data) }

        logger.info { "${congressmanList.size} found." }

        return copyOf(congressmanList)
    }

    private fun congressmanDetails(id: Int): Congressman {
        logger.info { "  Start fetching congressman $id details. " }
        val congressmanWithDetails = client.get(id).congressmanDetails
        val congressmanExpenses = expenseService.getAllCongressmanExpenses(id)
        return toCongressman(congressmanWithDetails, congressmanExpenses)
    }

    private fun OpenDataResponse<CongressmanClientModel>.iterator(): OpenDataIterator<CongressmanClientModel> =
        OpenDataIterator(this, CongressmanLinkNavigator(client))
}
