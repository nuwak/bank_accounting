package com.example.banka.model.entity

import com.example.banka.model.dto.account.AccountDto
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Version


@Entity
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var accountId: Long = 0,
    var balance: BigDecimal,
) {
    companion object

    @Version
    var version: Long = 0

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