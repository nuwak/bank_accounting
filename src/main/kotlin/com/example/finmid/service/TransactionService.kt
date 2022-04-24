package com.example.finmid.service

import com.example.finmid.model.dto.transaction.TransactionDto
import com.example.finmid.model.entity.Transaction
import com.example.finmid.model.entity.fromDto
import com.example.finmid.exception.TransactionException
import com.example.finmid.model.repository.AccountRepository
import com.example.finmid.model.repository.TransactionRepository
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val accountRepository: AccountRepository,
) {
    val log = KotlinLogging.logger {}

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Synchronized
    fun create(dto: TransactionDto): Transaction {
        val transaction = Transaction.fromDto(dto)

        val from = accountRepository.findByIdOrNull(dto.from)
            ?: "Accounts not found".let {
                log.warn(it)
                throw TransactionException(it)
            }

        val to = accountRepository.findByIdOrNull(dto.to)
            ?: "Accounts not found".let {
                log.warn(it)
                throw TransactionException(it)
            }

        if (from.balance < transaction.amount) "Insufficient account balance"
            .let {
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