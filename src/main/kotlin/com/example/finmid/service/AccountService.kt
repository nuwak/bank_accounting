package com.example.finmid.service

import com.example.finmid.model.dto.account.AccountDto
import com.example.finmid.model.entity.Account
import com.example.finmid.model.entity.fromDto
import com.example.finmid.model.entity.toDto
import com.example.finmid.model.repository.AccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
) {
    fun create(dto: AccountDto) = accountRepository.save(Account.fromDto(dto)).toDto()

    fun getById(id: Long) = accountRepository.findByIdOrNull(id)?.toDto()
}