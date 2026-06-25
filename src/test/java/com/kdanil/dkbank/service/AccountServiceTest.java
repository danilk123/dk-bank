package com.kdanil.dkbank.service;

import com.kdanil.dkbank.model.Account;
import com.kdanil.dkbank.persistance.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
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

    @Test
    public void getAccountNotFound() {
        when(accountRepository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> accountService.getAccount("123"));
    }

    @Test
    public void getAllAccounts() {
        accountService.getAllAccounts();

        verify(accountRepository, times(1)).findAll();
    }
}
