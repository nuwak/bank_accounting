package com.example.banka.model.repository

import com.example.banka.model.entity.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<Transaction, Long>