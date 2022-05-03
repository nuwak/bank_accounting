package com.example.banka.service

import com.example.banka.model.dto.account.AccountDto
import com.example.banka.model.entity.Account
import com.example.banka.model.entity.fromDto
import com.example.banka.model.entity.toDto
import com.example.banka.model.repository.AccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
) {
    fun create(dto: AccountDto) = accountRepository.save(Account.fromDto(dto)).toDto()

    fun getById(id: Long) = accountRepository.findByIdOrNull(id)?.toDto()
}