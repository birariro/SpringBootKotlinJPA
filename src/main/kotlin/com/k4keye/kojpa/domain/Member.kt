package com.k4keye.kojpa.domain

import javax.persistence.*

@Entity
class Member (
        @Id @GeneratedValue
        @Column(name = "member_id")
        val id:Long,
        val name:String,

        @Embedded //내장 타입이라는것을 명시
        val address:Address,

        @OneToMany(mappedBy = "member")
        val orders:List<Order>
)