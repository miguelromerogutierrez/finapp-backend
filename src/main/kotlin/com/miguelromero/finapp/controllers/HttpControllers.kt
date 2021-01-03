package com.miguelromero.finapp.controllers

import com.miguelromero.finapp.entities.Account
import com.miguelromero.finapp.entities.User
import com.miguelromero.finapp.repositories.AccountRepository
import com.miguelromero.finapp.repositories.TransactionRepository
import com.miguelromero.finapp.repositories.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val repository: TransactionRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()
}

@RestController
@RequestMapping("/api/accounts")
class AccountController(private val repository: AccountRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()
}

@RestController
@RequestMapping("/api/users")
class UserController(private val repository: UserRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @PostMapping("/")
    fun saveUser(@RequestBody user: User) = repository.save(user)
}