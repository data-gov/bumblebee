package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.ExpenseClient
import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.OpenDataResponse
import br.com.bumblebee.congressman.mapper.toExpenses
import br.com.bumblebee.congressman.repository.ExpenseRepository
import br.com.bumblebee.congressman.repository.model.Expense
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableList.copyOf
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val client: ExpenseClient, private val repository: ExpenseRepository) {

    private val logger = KotlinLogging.logger {}

    fun saveAllCongressmanExpenses(id: Int) {
        client.getCongressmanExpenses(id)
            .iterator().forEach { repository.saveAll(toExpenses(it)) }
    }

    fun getAllCongressmanExpenses(id: Int): ImmutableList<Expense> {
        return copyOf(toExpenses(allExpenses(id)))
    }

    private fun allExpenses(id: Int): ImmutableList<ExpenseClientModel> {
        val allExpenses = mutableListOf<ExpenseClientModel>()

        logger.info { " Start fetching congressman $id expenses " }

        client.getCongressmanExpenses(id)
            .iterator()
            .forEach { allExpenses.addAll(it.data) }

        logger.info { " ${allExpenses.size} expenses found. " }
        logger.info { " Congressman $id expenses finished. " }

        return copyOf(allExpenses)
    }

    private fun OpenDataResponse<ExpenseClientModel>.iterator(): OpenDataIterator<ExpenseClientModel> =
        OpenDataIterator(this, ExpenseLinkNavigator(client))
}

