package com.kdanil.dkbank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The model class for a transaction.
 */
@Entity
@Data
@Table(name="Transactions")
public class Transaction {
    /**
     * Unique id of the transaction.
     */
    @Id
    private String id;

    /**
     * The timestamp when transaction been happen.
     */
    private LocalDateTime timestamp;

    /**
     * The account number.
     */
    private String accountNumber;

    /**
     * the value date of the transaction.
     */
    private LocalDate valueDate;

    /**
     * The type of the transaction. For example Debit or Credit.
     */
    private TransactionType type;

    /**
     * The amount of teh transaction.
     */
    private BigDecimal amount;

    /**
     * The text description associated with the transaction.
     */
    private String narrative;
}
