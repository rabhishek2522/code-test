package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", "Checking", 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", "Checking", 100.0f);
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("004", "Checking", 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("004", 100.0f);
        assertEquals(0.0f, account.getBalance(), 0.01);
    }

    @Test
    public void getSumOfAccountHoldingsTest() {

        Account account = new Account("001", "Checking", 100.0f);
        bank.addAccount(account);

        Account account2 = new Account("002", "Checking", 100.0f);
        bank.addAccount(account2);

        Account account3 = new Account("003", "Checking", 200.0f);
        bank.addAccount(account3);

        Account account4 = new Account("004", "Checking", 100.0f);
        bank.addAccount(account4);

        assertEquals(500.0f,bank.getSumOfAccountHoldings(),0.01);
    }

    /**
     * Checking and prevent the account withdrawal limit too 100
     */
    @Test
    public void netIncomeProfitTest() {

        Account savingsAccount = new Account("005", "Savings", 500.0f);
        Account checkingAccount = new Account("006", "Checking", 100.0f);
        checkingAccount.setMonthlyFee(10.0f);
        savingsAccount.setMonthlyInterestRate(1.02f);
        bank.addAccount(savingsAccount);
        bank.addAccount(checkingAccount);

         assertEquals("Profit",bank.netIncome());
    }

    /**
     * Checking and prevent the account balance to negative
     */
    @Test
    public void netIncomeLossTest() {

        Account savingsAccount = new Account("005", "Savings", 50000.0f);
        Account checkingAccount = new Account("006", "Checking", 100.0f);
        checkingAccount.setMonthlyFee(10.0f);
        savingsAccount.setMonthlyInterestRate(1.02f);
        bank.addAccount(savingsAccount);
        bank.addAccount(checkingAccount);

         assertEquals("Loss",bank.netIncome());
    }
}