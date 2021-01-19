package com.miguelromero.finapp.services

import com.miguelromero.finapp.entities.*
import com.miguelromero.finapp.repositories.AccountRepository
import com.miguelromero.finapp.repositories.UserRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class AccountServices (
  private val repository: AccountRepository,
  private val userRepository: UserRepository
) {

  fun getAllAccounts(userId: Long) : ResponseAllAccounts {
    return mapFromAccounts(repository.findAllByUserId(userId))
  }

  fun saveAccount(reqBody: RequestAccount, userId: Long) : ResponseAccount {
    var user = userRepository.getOne(userId)
    var account = mapFromReqAccount(account = reqBody, user = user)
    return mapFromAccount(repository.save(account))
  }
}
