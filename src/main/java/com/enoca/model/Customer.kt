package com.example.demo.model

import jakarta.persistence.*
import java.util.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "customers", schema = "caseschema")
data class Customer(

    @Column
    val customerName: String,

    @OneToOne(mappedBy = "customer")
    val carts: Cart? = null,

    @OneToMany(mappedBy = "customer")
    val orders: List<Order> = ArrayList<Order>()

) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.customerName,
        builder.carts,
        builder.orders
    ) {
        super.id = builder.id
    }

    constructor() : this(Builder())

    class Builder {

        var id: UUID = UUID.randomUUID()
            private set

        var customerName: String = ""
            private set

        var carts: Cart? = null
            private set

        var orders: List<Order> = ArrayList<Order>()
            private set

        fun id(id: UUID) = apply { this.id = id }
        fun customerName(customerName: String) = apply { this.customerName = customerName }
        fun carts(carts: Cart) = apply { this.carts = carts }
        fun orders(orders: List<Order>) = apply { this.orders = orders }
        fun build() = Customer(this)
    }
}

