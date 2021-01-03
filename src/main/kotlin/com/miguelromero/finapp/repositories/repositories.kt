package com.miguelromero.finapp.repositories

import com.miguelromero.finapp.entities.Account
import com.miguelromero.finapp.entities.Transaction
import com.miguelromero.finapp.entities.User
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<Transaction, Long> {}

interface AccountRepository : CrudRepository<Account, Long> {}

interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
}