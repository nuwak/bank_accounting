package com.example.finmid.model.repository

import com.example.finmid.model.entity.Account
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.math.BigDecimal

interface AccountRepository : CrudRepository<Account, Long>