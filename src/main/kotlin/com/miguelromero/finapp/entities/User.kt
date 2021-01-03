package com.miguelromero.finapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    var email: String,
    var username: String,
    @Id @GeneratedValue var id: Long? = null
)