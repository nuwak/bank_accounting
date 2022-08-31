package com.example.banka.integration.service

import com.example.banka.integration.IntegrationTestBase
import com.example.banka.model.dto.transaction.TransactionDto
import com.example.banka.model.repository.AccountRepository
import com.example.banka.service.TransactionService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

internal class TransactionServiceTest : IntegrationTestBase() {

    @Autowired
    lateinit var transactionService: TransactionService

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun create() {
        val accountFrom = accountRepository.findByIdOrNull(1L) ?: error("No account")
        val accountTo = accountRepository.findByIdOrNull(2L) ?: error("No account")
        val amount = "1.11"
        val res = transactionService.create(
            TransactionDto(
                amount,
                1L,
                2L
            )
        )

        assertEquals(2L, res.txId)
        assertEquals(amount.toBigDecimal(), res.amount)
        val accountFromAfter = accountRepository.findByIdOrNull(1L) ?: error("No account")
        val accountToAfter = accountRepository.findByIdOrNull(2L) ?: error("No account")

        assertEquals(accountFrom.balance - amount.toBigDecimal(), accountFromAfter.balance)
        assertEquals(accountTo.balance + amount.toBigDecimal(), accountToAfter.balance)
    }
}