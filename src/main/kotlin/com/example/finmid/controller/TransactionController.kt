package com.example.finmid.controller

import com.example.finmid.model.dto.transaction.TransactionDto
import com.example.finmid.model.entity.Transaction
import com.example.finmid.model.entity.toDto
import com.example.finmid.exception.TransactionException
import com.example.finmid.service.TransactionService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("transaction")
class TransactionController(
    private val transactionService: TransactionService
) {
    @PutMapping
    fun create(@RequestBody req: TransactionDto): TransactionDto {
        return try {
            transactionService.create(req).toDto()
        } catch (e: TransactionException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }
}