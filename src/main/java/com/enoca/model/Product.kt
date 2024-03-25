package com.example.demo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "products", schema = "caseschema")
data class Product(

    @Column
    val productName: String,

    @Column
    var productPrice: Double

) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.productName,
        builder.productPrice
    ) {
        super.id = builder.id
    }

    constructor() : this(Builder())

    class Builder {

        var id: UUID = UUID.randomUUID()
            private set

        var productName: String = ""
            private set

        var productPrice: Double = 0.0
            private set

        fun id(id: UUID) = apply { this.id = id }
        fun productName(productName: String) = apply { this.productName = productName }
        fun productPrice(productPrice: Double) = apply { this.productPrice = productPrice }
        fun build() = Product(this)
    }
}
