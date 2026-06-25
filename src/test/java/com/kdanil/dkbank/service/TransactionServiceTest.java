package com.kdanil.dkbank.service;

import com.kdanil.dkbank.model.Transaction;
import com.kdanil.dkbank.persistance.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TransactionServiceTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Test
    public void getTransactions() {
        String accountNumber = "123";
        transactionService.getTransactions(accountNumber);

        verify(accountService, times(1)).getAccount(accountNumber);
        verify(transactionRepository, times(1)).findAllByAccountNumber(accountNumber);
    }

    @Test
    public void getTransactionsResponse() {
        String accountNumber = "123";
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(accountNumber);
        List<Transaction> transactionList = Arrays.asList(transaction);

        when(transactionRepository.findAllByAccountNumber(accountNumber)).thenReturn(transactionList);
        List<Transaction> response = transactionService.getTransactions(accountNumber);

        verify(accountService, times(1)).getAccount(accountNumber);
        verify(transactionRepository, times(1)).findAllByAccountNumber(accountNumber);
        assertEquals(transactionList, response);
    }
}
