package com.k4keye.kojpa.domain

import javax.persistence.*

@Entity
class Delivery (
        @Id @GeneratedValue
        @Column(name = "delivery_id")
        val id :Long,
        @OneToOne(mappedBy = "delivery")
        val order:Order,
        @Embedded
        val address:Address,
        @Enumerated(EnumType.STRING)
        val status:DeliveryStatus
        )
