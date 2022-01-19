package com.k4keye.kojpa.domain

import com.k4keye.kojpa.domain.item.Item
import javax.persistence.*

@Entity
class Category (
        @Id @GeneratedValue
        @Column(name = "category_id")
        val id: Long,

        val name:String,

        @ManyToMany
        @JoinTable(name = "category_item",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")])
        val items:MutableList<Item>,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "parent_id")
        val parent:Category,

        @OneToMany(mappedBy = "parent")
        val child :MutableList<Category>

        )