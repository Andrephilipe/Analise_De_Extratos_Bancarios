package com.iteratrlearning.realsoftwaredevelopment;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
