package com.kdanil.dkbank.service;

import com.kdanil.dkbank.model.Transaction;
import com.kdanil.dkbank.persistance.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service to manage transactions.
 */
@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    /**
     * Gets available transactions for the specified account number.
     * @param accountNumber the account number
     * @return list of transactions or exception if the account is not found.
     */
    public List<Transaction> getTransactions(String accountNumber) {
        //verify whether the account exists
        accountService.getAccount(accountNumber);
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }

}
