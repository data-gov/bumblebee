package br.com.bumblebee.congressman.repository

import br.com.bumblebee.congressman.repository.model.Expense
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@SpringBootTest
@RunWith(SpringRunner::class)
internal class ExpenseRepositoryTest {

    @Autowired
    private lateinit var repository: ExpenseRepository

    @Before
    fun setUp() = repository.deleteAll()

    @Test
    fun assertThatExpenseIseBeingSaved() {
        repository.save(Expense("SUPER_COOL_ID"))
        val allExpenses = repository.findAll()

        assertEquals(1, allExpenses.size)
    }
}
