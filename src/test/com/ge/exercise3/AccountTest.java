package com.ge.exercise3;

import com.ge.exercise3.exception.BalanceNotAvaiableException;
import com.ge.exercise3.exception.OverdrawnLimitExceededException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    Account checkingAccount;
    Account savingsAccount;

    @Before
    public void setUp() {
        checkingAccount = new Account("001", "Checking");
        savingsAccount = new Account("002", "Savings");
    }

    @Test
    public void depositAndWithdrawTest() {
        checkingAccount.setAccountType("Checking");
        checkingAccount.setBalance(0.0f);
        checkingAccount.deposit(100.0f);
        assertEquals(100.0f, checkingAccount.getBalance(), 0.01);
        checkingAccount.withdraw(100.0f);
        assertEquals(0.0f, checkingAccount.getBalance(), 0.01);
    }

    @Test
    public void valueNextMonthTest() {
        checkingAccount = new Account("003", "Checking", 100.0f);
        assertEquals(100.0f, checkingAccount.valueNextMonth(), 0.01f);

        savingsAccount = new Account("004", "Savings", 100.0f);
        assertEquals(101.0f, savingsAccount.valueNextMonth(), 0.01f);

        checkingAccount.setMonthlyFee(10.0f);
        assertEquals(90.0f, checkingAccount.valueNextMonth(), 0.01f);

        savingsAccount.setMonthlyInterestRate(1.05f);
        assertEquals(105.0f, savingsAccount.valueNextMonth(), 0.01f);
    }

    @Test
    public void toStringTest() {
        savingsAccount = new Account("005", "Savings", 0.0f);
        assertEquals("No fee savings account #005", savingsAccount.toString());

        checkingAccount = new Account("006", "Checking", 0.0f);
        assertEquals("No fee checking account #006", checkingAccount.toString());

        checkingAccount.setMonthlyFee(10.0f);
        assertEquals("Checking account #006", checkingAccount.toString());

        savingsAccount.setMonthlyInterestRate(1.02f);
        assertEquals("High interest no fee savings account #005", savingsAccount.toString());
    }

    @Test(expected = OverdrawnLimitExceededException.class)
    public void checkWithdrawalLimitTest(){
        checkingAccount= new Account("005", "Checking", 500.0f);
        checkingAccount.withdraw(200);

    }
    @Test(expected = BalanceNotAvaiableException.class)
    public void checkNegativeBalanceTest(){
        savingsAccount= new Account("006", "Savings", 100.0f);
        savingsAccount.withdraw(101);

    }
}