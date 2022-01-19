package com.k4keye.kojpa.domain

import javax.persistence.*

@Entity
class Delivery (
        @Id @GeneratedValue
        @Column(name = "delivery_id")
        val id :Long,
        @OneToOne(mappedBy = "delivery")
        val order:Order,
        @Embedded //내장 객체
        val address:Address,
        @Enumerated(EnumType.STRING) //반드시 type 를 string 로 해야한다.
        val status:DeliveryStatus
        )
