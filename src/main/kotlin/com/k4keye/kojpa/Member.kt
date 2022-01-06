package com.k4keye.kojpa

import javax.persistence.*

@Entity
class Member (
        @Id
        @GeneratedValue
        val id:Long,
        val username:String
        )