package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
        getAccount(accountNumber).withdraw(amount);
    }

    public int numAccounts() {
        return accountMap.size();
    }

    /**
     * Calculate Sum of holdings of the account
     * @return
     */
    public float getSumOfAccountHoldings(){

       return  accountMap.values().stream().map(Account::getBalance).reduce(0.0f, Float::sum);
    }

    /**
     * Calculate Net Income
     * @return
     */
    public String netIncome(){

       float sumOFHoldings = getSumOfAccountHoldings();
       float sumOfIncome = accountMap.values().stream().map(Account::valueNextMonth).reduce(0.0f, Float::sum);
       float ammoutSpent = sumOfIncome- sumOFHoldings;
       float monthlyFeeCollected = accountMap.values().stream().map(Account::getMonthlyFee).reduce(0.0f, Float::sum);
       return (monthlyFeeCollected - ammoutSpent)> 0 ? "Profit":"Loss";
    }
}
