package br.com.bumblebee.api.congressman.repository

import br.com.bumblebee.api.congressman.repository.model.Congressman
import org.springframework.data.mongodb.repository.MongoRepository

interface CongressmanRepository : MongoRepository<Congressman, String>
