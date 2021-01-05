package com.miguelromero.finapp.controllers

import com.miguelromero.finapp.entities.*
import com.miguelromero.finapp.repositories.AccountRepository
import com.miguelromero.finapp.repositories.TransactionRepository
import com.miguelromero.finapp.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.set
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val repository: TransactionRepository, private val accountRepository: AccountRepository) {

  @GetMapping("/{accountId}")
  fun findAll(@PathVariable(value = "accountId") id: Long ) = repository.findAllByAccountId(id)

  @PostMapping("/")
  fun saveTransaction(@RequestBody reqBody: RequestTransaction) : Transaction {
    var account = accountRepository.getOne(reqBody.account_id)
    var transaction = Transaction(
      account = account,
      amount = reqBody.amount,
      inTransaction = reqBody.inTransaction,
      outTransaction = reqBody.outTransaction
    )
    return repository.save(transaction)
  }
}

@RestController
@RequestMapping("/api/accounts")
class AccountController(private val repository: AccountRepository, private val userRepository: UserRepository) {

  @GetMapping("/")
  fun findAll() = repository.findAll()

  @GetMapping("/{id}")
  fun findById(@PathVariable(value = "id") id: Long ) = repository.findById(id)

  @PostMapping("/")
  fun saveAccount(@RequestBody reqBody: RequestAccount): Account {
    var user = userRepository.getOne(reqBody.user_id)
    var account = Account(alias = reqBody.alias, bankName = reqBody.bankName, user = user)
    return repository.save(account)
  }
}

@RestController
@RequestMapping("/api/users")
class UserController(private val repository: UserRepository) {

  @GetMapping("/")
  fun findAll() = repository.findAll()

  @PostMapping("/")
  fun saveUser(@RequestBody user: User) = repository.save(user)
}

@Controller
class HTMLController {

  @GetMapping("/")
  fun index(model: Model): String {
    model["title"] = "Fin App"
    return "app"
  }
}
