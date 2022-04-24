package com.example.finmid.model.entity

import com.example.finmid.model.dto.account.AccountDto
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var accountId: Long? = null,
    var balance: BigDecimal,
) {
    companion object

    @CreationTimestamp
    lateinit var created: Instant

    @UpdateTimestamp
    lateinit var updated: Instant
}

fun Account.toDto() =
    AccountDto(accountId = accountId, balance = balance)

fun Account.Companion.fromDto(dto: AccountDto) = with(dto) {
    Account(balance = balance)
}