package com.k4keye.kojpa.domain

import javax.persistence.Embeddable

@Embeddable
class Address(
        val city:String,
        val ctreet:String,
        val zipcode:String
)
