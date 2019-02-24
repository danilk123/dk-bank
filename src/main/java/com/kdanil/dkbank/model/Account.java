package com.kdanil.dkbank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The model class for an account.
 */
@Entity
@Data
@Table(name="Accounts")
public class Account {
    /**
     * An account number. The unique identifier.
     */
    @Id
    private String number;

    /**
     * Name of account.
     */
    private String name;

    /**
     * The type of the account. Current, saving, etc.
     */
    private AccountType type;

    /**
     * The timestamp for the balance of teh account.
     */
    private LocalDateTime balanceDateTime;

    /**
     * The currency for the account.
     */
    private String currency;

    /**
     * Current balance of the account
     */
    private BigDecimal balance;

}
