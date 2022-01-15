package com.k4keye.kojpa.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book (
        val author :String,
        val isbn:String
): Item()

