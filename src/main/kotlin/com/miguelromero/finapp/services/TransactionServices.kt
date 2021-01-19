package com.miguelromero.finapp.services

import com.miguelromero.finapp.entities.*
import com.miguelromero.finapp.repositories.AccountRepository
import com.miguelromero.finapp.repositories.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionServices(
  private val repository: TransactionRepository, private val accountRepository: AccountRepository
) {
  fun getAllTransactions(account_id: Long): ResponseAllTransactions {
    return mapToAllTransactions(repository.findAllByAccountId(account_id));
  }

  fun saveTransaction(transactionReq: RequestTransaction, accountId: Long): ResponseTransaction {
    var account = accountRepository.getOne(accountId)
    var transaction = mapFromReqTransaction(transactionReq, account)
    return mapToResponseTransaction(repository.save(transaction))
  }
}
