package com.example.banka.model.repository

import com.example.banka.model.entity.Account
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.QueryHints
import org.springframework.data.repository.CrudRepository
import javax.persistence.LockModeType
import javax.persistence.QueryHint

interface AccountRepository : CrudRepository<Account, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(*arrayOf(QueryHint(name = "javax.persistence.lock.timeout", value = "3000")))
    fun findByAccountId(accountId: Long): Account?
}