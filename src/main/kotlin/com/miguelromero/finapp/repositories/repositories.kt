package com.miguelromero.finapp.repositories

import com.miguelromero.finapp.entities.Account
import com.miguelromero.finapp.entities.Transaction
import com.miguelromero.finapp.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : JpaRepository<Transaction, Long> {

  @Query("FROM Transaction WHERE account_id = :accountId")
  fun findAllByAccountId(@Param("accountId") accountId: Long) : List<Transaction>
}

@Repository
interface AccountRepository : JpaRepository<Account, Long> {}

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}
