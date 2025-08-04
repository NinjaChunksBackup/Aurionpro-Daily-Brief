
DROP DATABASE IF EXISTS bank_demo;
CREATE DATABASE bank_demo;
USE bank_demo;

-- ========================
-- Create accounts table

CREATE TABLE accounts (
    acc_id INT PRIMARY KEY,
    acc_holder VARCHAR(50),
    balance DECIMAL(10, 2) CHECK (balance >= 0)
);

-- ========================

INSERT INTO accounts VALUES
(1, 'Alice', 1000.00),
(2, 'Bob', 500.00);

SELECT * FROM accounts;

-- =======================================
-- STEP 3: Successful Transaction (COMMIT)
-- =======================================
-- Alice sends ₹200 to Bob



START TRANSACTION;

UPDATE accounts SET balance = balance - 200 WHERE acc_id = 1;
UPDATE accounts SET balance = balance + 200 WHERE acc_id = 2;

COMMIT;

SELECT * FROM accounts;

-- ============================================
-- Transaction (ROLLBACK Trigger)
-- ============================================
-- Alice tries to send ₹2000 to Bob (only 800 in acc now)
-- balance goes negative , violates CHECK constraint

START TRANSACTION;

UPDATE accounts SET balance = 600 WHERE acc_id = 1;
UPDATE accounts SET balance = 900 WHERE acc_id = 2;

-- The first update will fail due to CHECK constraint on balance
-- So even the second won't execute, and we need to roll back

ROLLBACK;

SELECT * FROM accounts;

-- ========================================
-- STEP 5: SAVEPOINT & ROLLBACK TO SAVEPOINT
-- ========================================
-- Now do a partial rollback

START TRANSACTION;

-- Alice sends ₹100 to Bob
UPDATE accounts SET balance = balance - 100 WHERE acc_id = 1;
SAVEPOINT after_debit;


UPDATE accounts SET balance = balance - 200 WHERE acc_id = 1;
SAVEPOINT after_debit2;


-- Mistakenly adds ₹1000 to Bob instead of ₹100
UPDATE accounts SET balance = balance + 1000 WHERE acc_id = 2;

-- Realize the mistake: rollback to point after debit
ROLLBACK TO SAVEPOINT after_debit;


ROLLBACK TO SAVEPOINT after_debit2;

-- Now correctly credit ₹100 to Bob
UPDATE accounts SET balance = balance + 100 WHERE acc_id = 2;

COMMIT;

SELECT * FROM accounts;

