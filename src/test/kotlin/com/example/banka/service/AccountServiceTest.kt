package com.example.banka.service

import com.example.banka.model.dto.account.AccountDto
import com.example.banka.model.entity.Account
import com.example.banka.model.entity.toDto
import com.example.banka.model.repository.AccountRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class AccountServiceTest {
    @Mock
    lateinit var accountRepository: AccountRepository

    @InjectMocks
    lateinit var accountService: AccountService

    private val ACCOUNT_ID = 1L

    @Test
    fun create() {
        val fromAccount = Account(balance = "42.42".toBigDecimal())
        val savedAccount = Account(ACCOUNT_ID, "42.42".toBigDecimal())
            `when`(accountRepository.save(any()))
            .thenReturn(savedAccount)

        val result = accountService.create(fromAccount.toDto())
        assertNotNull(result)
        assertEquals(savedAccount.toDto(), result)
    }

    @Test
    fun getById() {
        doReturn(Optional.of(Account(ACCOUNT_ID, "42.42".toBigDecimal())))
            .`when`(accountRepository)
            .findById(ACCOUNT_ID)

        val result = accountService.getById(1L)
        assertNotNull(result)
        val expected = AccountDto(ACCOUNT_ID, "42.42".toBigDecimal())
        assertEquals(expected, result)
    }
}