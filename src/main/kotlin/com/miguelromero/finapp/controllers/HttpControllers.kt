package com.miguelromero.finapp.controllers

import com.miguelromero.finapp.entities.*
import com.miguelromero.finapp.repositories.AccountRepository
import com.miguelromero.finapp.repositories.TransactionRepository
import com.miguelromero.finapp.repositories.UserRepository
import com.miguelromero.finapp.services.AccountServices
import com.miguelromero.finapp.services.TransactionServices
import org.springframework.stereotype.Controller
import org.springframework.ui.set
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val transactionServices: TransactionServices) {

  @CrossOrigin(origins = ["*"])
  @GetMapping("/{accountId}")
  fun findAll(
    @PathVariable(value = "accountId") id: Long,
    @RequestHeader("X-UID", required = true) userId: Long
  ) = transactionServices.getAllTransactions(account_id = id)

  @CrossOrigin(origins = ["*"])
  @PostMapping("/{accountId}")
  fun saveTransaction(
    @RequestBody reqBody: RequestTransaction,
    @PathVariable(value = "accountId") accountId: Long,
    @RequestHeader("X-UID", required = true) userId: Long
  ) = transactionServices.saveTransaction(reqBody, accountId)
}

@RestController
@RequestMapping("/api/accounts")
class AccountController(
  private val accountService : AccountServices,
  private val repository: AccountRepository, private val userRepository: UserRepository
) {

  @CrossOrigin(origins = ["*"])
  @GetMapping("/")
  fun findAll(@RequestHeader("X-UID", required = true) userId: Long) = accountService.getAllAccounts(userId)

  @GetMapping("/{id}")
  fun findById(@PathVariable(value = "id") id: Long ) = repository.findById(id)

  @CrossOrigin(origins = ["*"])
  @PostMapping("/")
  fun saveAccount(@RequestHeader("X-UID", required = true) userId: Long, @RequestBody reqBody: RequestAccount) = accountService.saveAccount(reqBody, userId)
}

@RestController
@RequestMapping("/api/users")
class UserController(private val repository: UserRepository) {

  @CrossOrigin(origins = ["*"])
  @GetMapping("/")
  fun findByEmail(@RequestParam("email", required = true) mail: String) = repository.findByEmail(mail)

  @CrossOrigin(origins = ["*"])
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
