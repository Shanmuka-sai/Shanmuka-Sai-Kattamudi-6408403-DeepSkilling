DECLARE
    CURSOR customer_discount_cursor IS
        SELECT customer_id, loan_interest_rate
        FROM customers
        WHERE loan_interest_rate IS NOT NULL
        AND FLOOR(MONTHS_BETWEEN(SYSDATE, dob)/12) > 60;

    CURSOR vip_customer_cursor IS
        SELECT customer_id
        FROM customers
        WHERE balance > 10000 AND is_vip = 'FALSE';

    CURSOR loan_reminder_cursor IS
        SELECT c.customer_id, c.name, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR customer_rec IN customer_discount_cursor LOOP
        UPDATE customers
        SET loan_interest_rate = loan_interest_rate - 1
        WHERE customer_id = customer_rec.customer_id;
        DBMS_OUTPUT.PUT_LINE('Discount applied to customer ' || customer_rec.customer_id);
    END LOOP;

    FOR vip_customer_rec IN vip_customer_cursor LOOP
        UPDATE customers
        SET is_vip = 'TRUE'
        WHERE customer_id = vip_customer_rec.customer_id;
        DBMS_OUTPUT.PUT_LINE('Customer ' || vip_customer_rec.customer_id || ' promoted to VIP');
    END LOOP;

    FOR loan_rec IN loan_reminder_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan due date for customer ' || loan_rec.name || ' is ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
    END LOOP;

    COMMIT;
END;
/
