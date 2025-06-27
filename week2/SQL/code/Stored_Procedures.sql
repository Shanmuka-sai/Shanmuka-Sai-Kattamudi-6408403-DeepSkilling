CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE savings_accounts
    SET balance = balance * 1.01;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully');
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id     NUMBER,
    p_bonus_percentage  NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary * (1 + p_bonus_percentage / 100)
    WHERE department_id = p_department_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus updated successfully for department ' || p_department_id);
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account_id  NUMBER,
    p_target_account_id  NUMBER,
    p_amount             NUMBER
) AS
    v_source_balance     NUMBER;
BEGIN
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account_id;

    IF v_source_balance >= p_amount THEN
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account_id;

        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_target_account_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Fund transfer successful');
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
    END IF;
END;
/
