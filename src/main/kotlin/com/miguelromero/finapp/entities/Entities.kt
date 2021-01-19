package com.miguelromero.finapp.entities

import com.fasterxml.jackson.annotation.*
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "transactions")
class Transaction(
  var inTransaction: Boolean,
  var outTransaction: Boolean,
  var amount: BigDecimal,

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("account_id")
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id") var account: Account,

  @Id @GeneratedValue var id: Long? = null
)

@Entity
@Table(name = "accounts")
class Account(
  var alias: String,
  var bankName: String,
  var amount: BigDecimal,
  var type: AccountTypes,

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("user_id")
  @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
  @JoinColumn(name = "user_id")
  var user: User,

  @Id @GeneratedValue var id: Long? = null
)

@Entity
@Table(name = "users")
class User(
  var email: String,
  var username: String,
  @Id @GeneratedValue var id: Long? = null
)
