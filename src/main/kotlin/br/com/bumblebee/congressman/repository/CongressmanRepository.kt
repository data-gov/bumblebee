package br.com.bumblebee.congressman.repository

import br.com.bumblebee.congressman.repository.model.Congressman
import org.springframework.data.mongodb.repository.MongoRepository

interface CongressmanRepository : MongoRepository<Congressman, String>
