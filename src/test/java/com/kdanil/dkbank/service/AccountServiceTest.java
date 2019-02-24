package com.kdanil.dkbank.service;

import com.kdanil.dkbank.model.Account;
import com.kdanil.dkbank.persistance.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;


    @Test
    public void getAccount() {

        String accountNumber = "123";

        Account account = new Account();
        account.setNumber(accountNumber);
        when(accountRepository.findById(accountNumber)).thenReturn(Optional.of(account));

        Account result = accountService.getAccount(accountNumber);

        verify(accountRepository, times(1)).findById(accountNumber);
        assertEquals(account, result);
    }


    @Test(expected = ResourceNotFoundException.class)
    public void getAccountNotFound() {

        when(accountRepository.findById(anyString())).thenReturn(Optional.empty());

        accountService.getAccount("123");

        fail("Mast throw an exception");
    }

    @Test
    public void getAllAccounts() {
        accountService.getAllAccounts();

        verify(accountRepository, times(1)).findAll();
    }
}