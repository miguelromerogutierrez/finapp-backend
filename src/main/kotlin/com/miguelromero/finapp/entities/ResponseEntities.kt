package com.miguelromero.finapp.entities

import java.math.BigDecimal
import java.text.DecimalFormat

class ResponseMessage<T>(
  var messages: Array<String>?,
  var status: String?,
  var payload: T
)

class ResponseAccount(
  var account_id: Long?,
  var amount: String,
  var amountRaw: BigDecimal,
  var alias: String,
  var bankName: String,
  var type: AccountTypes
)
class ResponseAllAccounts(
  var accounts: List<ResponseAccount>,
  var totalAmount: String,
  var totalAmountRaw: BigDecimal
)

fun mapFromAccounts(accounts: List<Account>): ResponseAllAccounts {
  var totalAmount : BigDecimal = BigDecimal(0)
  val df = DecimalFormat("#,##0.00")
  accounts.forEach { account -> totalAmount.add(account.amount) }

  return ResponseAllAccounts(
    accounts = accounts.map { mapFromAccount(it) },
    totalAmount = "$${df.format(totalAmount)}",
    totalAmountRaw = totalAmount
  )
}
fun mapFromAccount(acct: Account) : ResponseAccount {
  val df = DecimalFormat("#,##0.00")
  return ResponseAccount(
    account_id = acct.id,
    amount = "$${df.format(acct.amount)}",
    amountRaw = acct.amount,
    alias = acct.alias,
    bankName = acct.bankName,
    type = acct.type
  );
}
fun mapFromReqAccount(account: RequestAccount, user: User) : Account {
  return Account(alias = account.alias, bankName = account.bankName, user = user, amount = account.initialAmount, type = getAccountType(account.type))
}
fun getAccountType(type: String) = when(type) {
  "credit" -> AccountTypes.CREDIT
  "debit" -> AccountTypes.DEBIT
  "invest" -> AccountTypes.INVEST
  "saves" -> AccountTypes.SAVES
  else -> AccountTypes.DEBIT
}

class ResponseTransaction(
  var transaction_id: Long?,
  var rawAmount: BigDecimal,
  var amount: String,
  var transactionType: String,
)
class ResponseAllTransactions(
  var transactions: List<ResponseTransaction>
)
fun mapFromReqTransaction(transaction: RequestTransaction, account: Account): Transaction {
  return Transaction(
    account = account,
    amount = transaction.amount,
    inTransaction = transaction.inTransaction,
    outTransaction = transaction.outTransaction
  )
}
fun mapToResponseTransaction(transaction: Transaction): ResponseTransaction {
  val df = DecimalFormat("#,##0.00")
  return ResponseTransaction(
    transaction_id = transaction.id,
    rawAmount = transaction.amount,
    amount = "$${df.format(transaction.amount)}",
    transactionType = if (transaction.inTransaction) "IN" else "OUT",
  )
}
fun mapToAllTransactions(transactions: List<Transaction>): ResponseAllTransactions {
  return ResponseAllTransactions(transactions = transactions.map { mapToResponseTransaction(it) })
}
