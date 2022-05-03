package com.example.banka.model.dto.transaction

data class TransactionDto(
    val amount: String,
    val from: Long,
    val to: Long,
)
