package com.example.banka.integration.controller

import com.example.banka.integration.IntegrationTestBase
import com.example.banka.model.dto.transaction.TransactionDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@AutoConfigureMockMvc
internal class TransactionControllerTest : IntegrationTestBase() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val mapper = ObjectMapper()

    @Test
    fun create() {
        val payload = TransactionDto(
            "11.2",
            1L,
            2L
        )
        val json = mapper.writeValueAsString(payload)
        mockMvc.perform(
            MockMvcRequestBuilders.post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
            .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value("11.2"))
    }
}