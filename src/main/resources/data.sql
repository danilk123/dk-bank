-- add accounts
INSERT INTO Accounts (number, name, type, balance_Date_Time, currency, balance) values ('1001', 'account-1001', 0, CURRENT_TIMESTAMP(), 'AUD', 5000);
INSERT INTO Accounts (number, name, type, balance_Date_Time, currency, balance) values ('2002', 'account-2002', 1, CURRENT_TIMESTAMP(), 'AUD', 5000);

-- add transactions for account 1001
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '1001', CURRENT_DATE(), 0, 200, 'cinema ticket');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '1001', CURRENT_DATE(), 0, 300, 'FLOWERS');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '1001', CURRENT_DATE(), 0, 400, 'water bill');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '1001', CURRENT_DATE(), 0, 500, 'bank fees');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '1001', CURRENT_DATE(), 1, 3000, 'salary');

-- add transactions for account 2002
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '2002', CURRENT_DATE(), 0, 202, 'theatre ticket');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '2002', CURRENT_DATE(), 0, 302, 'coffee');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '2002', CURRENT_DATE(), 0, 402, 'gas bill');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '2002', CURRENT_DATE(), 0, 502, 'annual bank fees');
INSERT INTO Transactions (id, timestamp, account_Number, value_Date, type, amount, narrative) values (RANDOM_UUID(), CURRENT_TIMESTAMP(), '2002', CURRENT_DATE(), 1, 3002, 'salary bonus');

