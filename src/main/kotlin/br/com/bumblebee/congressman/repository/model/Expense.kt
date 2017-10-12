package br.com.bumblebee.congressman.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "expense")
data class Expense(@Id val id : String)
