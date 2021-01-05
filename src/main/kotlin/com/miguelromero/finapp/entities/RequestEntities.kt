package com.miguelromero.finapp.entities

import java.math.BigDecimal

class RequestAccount(
  var alias: String,
  var bankName: String,
  var user_id: Long
)

class RequestTransaction(
  var inTransaction: Boolean,
  var outTransaction: Boolean,
  var amount: BigDecimal,
  var account_id: Long
)
