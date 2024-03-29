package com.k4keye.kojpa.domain

import com.k4keye.kojpa.domain.item.Item
import javax.persistence.*

@Entity
class OrderItem (
        @Id @GeneratedValue
        @Column(name = "order_item_id")
        val id:Long,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "item_id")
        val item: Item,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")
        val order:Order,
        val orderPrice:Int,
        val count:Int
        )
