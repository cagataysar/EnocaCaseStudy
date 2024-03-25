package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "carts", schema = "caseschema")
data class Cart(

    val cartName: String,

    @OneToOne
    val customer: Customer?,

    var totalPrice: Int

): BaseEntity() {

    constructor(builder: Builder) : this(
        builder.cartName,
        builder.customer,
        builder
    ) {
        super.id = builder.id
    }

    constructor() : this(Builder())

    class Builder {

        var id: UUID = UUID.randomUUID()
            private set

        var cartName: String = ""
            private set

        var customer: Customer? = null
            private set

        fun id(id: UUID) = apply { this.id = id }
        fun cartName(cartName: String) = apply { this.cartName = cartName }
        fun customer(customer: Customer) = apply { this.customer = customer }
        fun build() = Cart(this)
    }
}

