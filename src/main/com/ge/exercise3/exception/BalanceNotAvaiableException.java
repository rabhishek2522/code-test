package com.ge.exercise3.exception;

/**
 * BalanceNotAvaiableException prevent savings accounts from ever having a negative balance in the account
 */
public class BalanceNotAvaiableException extends RuntimeException {

    /**
     * Parametrized construtor with one arg
     * @param ammount
     */
    public BalanceNotAvaiableException(Float ammount) {
        super("Balance cannot be negative, Current account balance is : "+ ammount);
    }
}
