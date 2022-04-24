package com.example.finmid.model.repository

import com.example.finmid.model.entity.Transaction
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.math.BigDecimal

interface TransactionRepository : CrudRepository<Transaction, Long> {

//    @Modifying(clearAutomatically = true)
//    @Query("update Transaction set balance")
//    fun transfer(fromBalance: BigDecimal, toBalance: BigDecimal, fromId: Long, toId: Long)
}