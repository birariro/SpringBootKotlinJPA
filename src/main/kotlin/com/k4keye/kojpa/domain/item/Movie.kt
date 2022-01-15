package com.k4keye.kojpa.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie(
        val director:String,
        val actor:String,
) : Item()
