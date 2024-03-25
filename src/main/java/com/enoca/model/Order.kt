package com.example.demo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "orders", schema = "caseschema")
data class Order(

    @Column
    val orderName: String,

    @ManyToOne
    val customer: Customer?,

): BaseEntity() {

    constructor(builder: Builder) : this(
        builder.orderName,
        builder.customer
    ) {
        super.id = builder.id
    }

    constructor() : this(Builder())

    class Builder {

        var id: UUID = UUID.randomUUID()
            private set

        var orderName: String = ""
            private set

        var customer: Customer? = null
            private set

        fun id(id: UUID) = apply { this.id = id }
        fun orderName(orderName: String) = apply { this.orderName = orderName }
        fun customer(customer: Customer) = apply { this.customer = customer }
        fun build() = Order(this)
    }
}

