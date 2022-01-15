package com.k4keye.kojpa.domain.item

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
abstract class Item {
        @Id @GeneratedValue
        @Column(name = "item_id")
        val id:Long = 0

        val name:String =""
        val price:Int =0
        val stockQuantity:Int =0

}