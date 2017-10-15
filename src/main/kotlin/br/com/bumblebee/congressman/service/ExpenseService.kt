package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.ExpenseClient
import br.com.bumblebee.congressman.client.model.ExpenseClientModel
import br.com.bumblebee.congressman.client.model.OpenDataResponse
import br.com.bumblebee.congressman.mapper.toExpenses
import br.com.bumblebee.congressman.repository.ExpenseRepository
import br.com.bumblebee.congressman.repository.model.Expense
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val client: ExpenseClient, private val repository: ExpenseRepository) {

    fun saveCongressmanExpenses(id: Int): MutableList<Expense>? {
        val expensesResponses = client.getCongressmanExpenses(id)
        return repository.saveAll(toExpenses(expensesResponses))
    }

    fun saveAllCongressmanExpenses(id: Int) {
        client.getCongressmanExpenses(id)
            .iterator().forEach { repository.saveAll(toExpenses(it)) }
    }

    fun OpenDataResponse<ExpenseClientModel>.iterator(): OpenDataIterator<ExpenseClientModel> =
        OpenDataIterator(this, ExpenseLinkNavigator(client))
}
