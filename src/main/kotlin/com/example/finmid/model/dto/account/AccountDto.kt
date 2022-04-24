package com.example.finmid.model.dto.account

import java.math.BigDecimal

data class AccountDto(
    val accountId: Long? = null,
    val balance: BigDecimal,
)
