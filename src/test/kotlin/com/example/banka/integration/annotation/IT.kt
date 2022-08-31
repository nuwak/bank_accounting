package com.example.banka.integration.annotation

import com.example.banka.integration.TestApplicationRunner
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ActiveProfiles("test")
@SpringBootTest(classes = [TestApplicationRunner::class])
annotation class IT
