package com.example.banka.controller

import com.example.banka.model.dto.transaction.TransactionDto
import com.example.banka.model.entity.Transaction
import com.example.banka.model.entity.toDto
import com.example.banka.exception.TransactionException
import com.example.banka.service.TransactionService
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