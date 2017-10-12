package br.com.bumblebee.congressman.repository

import br.com.bumblebee.congressman.repository.model.Expense
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class ExpenseRepositoryTest {

    @Autowired
    private lateinit var repository: ExpenseRepository

    @BeforeEach
    fun setUp() = repository.deleteAll()

    @Test
    @DisplayName("Should save a congressman expense into mongodb")
    fun assertThatExpenseIseBeingSaved() {
        repository.save(Expense("SUPER_COOL_ID"))
        val allExpenses = repository.findAll()

        assertEquals(1, allExpenses.size)
    }
}
