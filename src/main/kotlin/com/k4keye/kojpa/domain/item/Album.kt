package com.k4keye.kojpa.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("A")
class Album(
        val artist:String = "",
        val etc:String
) : Item()