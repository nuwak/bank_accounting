package com.example.banka.service

import com.example.banka.exception.TransactionException
import com.example.banka.model.dto.transaction.TransactionDto
import com.example.banka.model.entity.Transaction
import com.example.banka.model.entity.fromDto
import com.example.banka.model.repository.AccountRepository
import com.example.banka.model.repository.TransactionRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val accountRepository: AccountRepository,
) {
    val log = KotlinLogging.logger {}

    @Transactional
    fun create(dto: TransactionDto): Transaction {
        val transaction = Transaction.fromDto(dto)

        val from = accountRepository.findByAccountId(dto.from)
            ?: "Accounts not found".let {
                log.warn(it)
                throw TransactionException(it)
            }

        if (from.balance < transaction.amount) "Insufficient account balance"
            .let {
                log.warn(it)
                throw TransactionException(it)
            }

        val to = accountRepository.findByAccountId(dto.to)
            ?: "Accounts not found".let {
                log.warn(it)
                throw TransactionException(it)
            }

        if (from.accountId == to.accountId) "Accounts must be different"
            .let {
                log.warn(it)
                throw TransactionException(it)
            }

        from.balance -= transaction.amount
        to.balance += transaction.amount
        accountRepository.saveAll(listOf(from, to))

        return transactionRepository.save(transaction)
    }
}