package com.k4keye.kojpa.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="orders")
class Order(
        @Id @GeneratedValue
        @Column(name = "order_id")
        val id:Long,

        @ManyToOne
        @JoinColumn(name = "member_id") //member_id 로 연결하며 곳 외부키가된다.
        val member:Member,
        @OneToMany(mappedBy = "order")
        val orderItems :List<OrderItem>,
        @OneToOne
        @JoinColumn(name = "delivery_id")
        val delivery:Delivery,
        val orderDate:LocalDateTime, //주문 시간
        @Enumerated(EnumType.STRING)
        val status:OrderStatus
)
