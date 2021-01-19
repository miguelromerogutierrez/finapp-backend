package com.miguelromero.finapp.entities

import java.math.BigDecimal

class RequestAccount(
  var alias: String,
  var bankName: String,
  var type: String,
  var initialAmount: BigDecimal = BigDecimal(0)
)

class RequestTransaction(
  var inTransaction: Boolean,
  var outTransaction: Boolean,
  var amount: BigDecimal
)
