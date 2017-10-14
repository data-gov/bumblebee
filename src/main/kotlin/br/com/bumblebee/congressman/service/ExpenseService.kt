package br.com.bumblebee.congressman.service

import br.com.bumblebee.congressman.client.ExpenseClient
import br.com.bumblebee.congressman.mapper.toExpenses
import br.com.bumblebee.congressman.repository.ExpenseRepository
import br.com.bumblebee.congressman.repository.model.Expense
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val client: ExpenseClient, private val repository: ExpenseRepository) {

    fun saveCongressmanExpenses (congressmanId: Int): MutableList<Expense>? {
        val expensesResponses = client.getCongressmanExpenses(congressmanId)
        val expenses = toExpenses(expensesResponses)
        return repository.saveAll(expenses)
    }
}
