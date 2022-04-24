package com.example.finmid.model.dto.transaction

data class TransactionDto(
    val amount: String,
    val from: Long,
    val to: Long,
)
