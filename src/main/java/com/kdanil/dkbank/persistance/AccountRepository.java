package com.kdanil.dkbank.persistance;

import com.kdanil.dkbank.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Access to Accounts data base table.
 */
public interface AccountRepository extends CrudRepository<Account, String> {
}
