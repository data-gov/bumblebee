package br.com.bumblebee.api.congressman.repository

import br.com.bumblebee.api.congressman.repository.model.Expense
import org.springframework.data.mongodb.repository.MongoRepository

interface ExpenseRepository : MongoRepository<Expense, String>
