package com.example.banka.controller

import com.example.banka.model.dto.account.AccountDto
import com.example.banka.service.AccountService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("account")
class AccountController(
    private val accountService: AccountService,
) {
    val log = KotlinLogging.logger {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody req: AccountDto): AccountDto =
        accountService.create(req)

    @GetMapping("{accountId}")
    fun getById(@PathVariable accountId: Long): AccountDto =
        accountService.getById(accountId)
            ?: "Account id $accountId not found"
                .let {
                    log.warn(it)
                    throw ResponseStatusException(HttpStatus.NOT_FOUND, it)
                }
}