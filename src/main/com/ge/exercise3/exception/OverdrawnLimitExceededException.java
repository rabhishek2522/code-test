package com.ge.exercise3.exception;

/**
 * OverdrawnLimitExceededException prevent checking accounts from being overdrawn by more that $100
 */
public class OverdrawnLimitExceededException extends RuntimeException {
    /**
     * Parametrized construtor with one arg
     * @param ammout
     */
    public OverdrawnLimitExceededException(Float ammout) {
        super("Withdrawal limit can not be more than 100 is " + ammout);
    }
}
