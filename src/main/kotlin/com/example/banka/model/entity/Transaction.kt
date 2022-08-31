package com.example.banka.model.entity

import com.example.banka.model.dto.transaction.TransactionDto
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.*

@Entity
class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var txId: Long = 0,
    val amount: BigDecimal,
    @Column(name = "from_id")
    val from: Long,
    @Column(name = "to_id")
    val to: Long,
) {
    companion object

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", insertable = false, updatable = false)
    lateinit var accountFrom: Account

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", insertable = false, updatable = false)
    lateinit var accountTo: Account

    @CreationTimestamp
    lateinit var created: Instant

    @UpdateTimestamp
    lateinit var updated: Instant
}

//todo: настроить сериалайзер
fun Transaction.toDto() =
    TransactionDto(amount = amount.toString(), from = from, to = to)


fun Transaction.Companion.fromDto(dto: TransactionDto) = with(dto) {
    Transaction(amount = amount.toBigDecimal(), from = from, to = to)
}