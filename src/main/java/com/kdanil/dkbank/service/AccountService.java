package com.kdanil.dkbank.service;

import com.google.common.collect.Lists;
import com.kdanil.dkbank.model.Account;
import com.kdanil.dkbank.persistance.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The service is to access and manipulate by account information.
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Gets the account associated with the specified account number.
     * @param accountNumber the account number
     * @return the account for the account number
     * @exception ResourceNotFoundException if the account with the number is not found.
     */
    public Account getAccount(String accountNumber) {
        log.debug("Looking for account {}", accountNumber);
        Optional<Account> accountOptional = accountRepository.findById(accountNumber);
        if (!accountOptional.isPresent()) {
            log.error("Account {} not found", accountNumber);
            throw new ResourceNotFoundException("Account [" + accountNumber + "] not found");
        }
        return accountOptional.get();
    }

    /**
     * Gets list of all available accounts.
     * @return list of accounts
     */
    public List<Account> getAllAccounts() {
        log.debug("Loading all accounts");
        return Lists.newArrayList(accountRepository.findAll());
    }

}
