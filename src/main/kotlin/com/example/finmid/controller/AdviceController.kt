package com.example.finmid.controller

import com.example.finmid.exception.TransactionException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.Instant


@ControllerAdvice
class AdviceController : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [TransactionException::class])
    fun handleTransactionException(ex: TransactionException, request: WebRequest) =
        ResponseEntity(
            hashMapOf(
                "timestamp" to Instant.now(),
                "message" to ex.message,
                "status" to 400,
                "error" to HttpStatus.BAD_REQUEST.reasonPhrase,
            ),
            HttpStatus.BAD_REQUEST
        )
}