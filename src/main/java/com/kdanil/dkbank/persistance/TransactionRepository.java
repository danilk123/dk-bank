package com.kdanil.dkbank.persistance;

import com.kdanil.dkbank.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Access to Transactions data base table.
 */
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    List<Transaction> findAllByAccountNumber(String accountNumber);
}
