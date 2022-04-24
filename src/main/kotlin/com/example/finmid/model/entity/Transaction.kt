package com.example.finmid.model.entity

import com.example.finmid.model.dto.transaction.TransactionDto
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.*

@Entity
class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var txId: Long? = null,
    val amount: BigDecimal,
    @Column(name = "from_id")
    val from: Long,
    @Column(name = "to_id")
    val to: Long,
) {
    companion object

    @CreationTimestamp
    lateinit var created: Instant

    @UpdateTimestamp
    lateinit var updated: Instant
}

fun Transaction.toDto() =
    TransactionDto(amount = amount.toString(), from = from, to = to)


fun Transaction.Companion.fromDto(dto: TransactionDto) = with(dto) {
    Transaction(amount = amount.toBigDecimal(), from = from, to = to)
}