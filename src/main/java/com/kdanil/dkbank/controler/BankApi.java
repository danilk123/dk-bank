package com.kdanil.dkbank.controler;

import com.kdanil.dkbank.model.Account;
import com.kdanil.dkbank.model.Transaction;
import com.kdanil.dkbank.service.AccountService;
import com.kdanil.dkbank.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The controller to map REST requests to business services
 */
@RestController
@Slf4j
public class BankApi {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private HttpServletRequest servlet;

    /**
     * Gets an account by the account number.
     * @param accountNumber the account number.
     * @return the account if the account with the number exists or 404 error if not.
     */
    @RequestMapping (value = "api/account", method = RequestMethod.GET)
    public Account getAccountDetatis(@RequestParam("number") String accountNumber) {
        log.info("Incoming API request: {} {}", servlet.getMethod(), servlet.getRequestURI());
        return accountService.getAccount(accountNumber);
    }

    /**
     * Gets all available accounts.
     * @return list of accounts.
     */
    @RequestMapping (value = "api/accountList", method = RequestMethod.GET)
    public List<Account> getAccountList() {
        log.info("Incoming API request: {} {}", servlet.getMethod(), servlet.getRequestURI());
        return accountService.getAllAccounts();
    }

    /**
     * Gets available transactions for the specified account.
     * Will thow an exceptino if the account do not exists.
     * @param accountNumber the account number
     * @return list of transactions.
     */
    @RequestMapping (value = "api/transactions", method = RequestMethod.GET)
    public List<Transaction> getTransactions(@RequestParam("account") String accountNumber) {
        log.info("Incoming API request: {} {}", servlet.getMethod(), servlet.getRequestURI());
        return transactionService.getTransactions(accountNumber);
    }

}
