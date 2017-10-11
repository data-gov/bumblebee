package br.com.bumblebee.congressman.repository

import br.com.bumblebee.congressman.repository.model.Expense
import org.springframework.data.mongodb.repository.MongoRepository

interface ExpenseRepository : MongoRepository<Expense, String>
