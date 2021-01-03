package com.miguelromero.finapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Account(
    var alias: String,
    var bankName: String,
    @ManyToOne var user: User,
    @Id @GeneratedValue var id : Long? = null
)