package com.example.finmid.model.repository

import com.example.finmid.model.entity.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<Transaction, Long>