package com.miguelromero.finapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Transaction(
    var inTransaction: Boolean,
    var outTransaction: Boolean,
    var amount: Long,
    @ManyToOne var account: Account,
    @Id @GeneratedValue var id: Long? = null
)