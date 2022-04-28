package com.iteratrlearning.realsoftwaredevelopment;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    
    @FunctionalInterface
    public interface BankTransactionSummarizar {
        double summarize(double accumulator, BankTransaction bankTransaction);
    }

    @FunctionalInterface
    public interface BankTransactionFilter {
        boolean test(BankTransaction bankTransaction);
    }

    public class BankTransactionProcessor {

        private final List<BankTransaction> bankTransactions;

        public BankTransactionProcessor(final List<BankTransaction> bankTransactions) {
            this.bankTransactions = bankTransactions;
        }

        public double summarizeTransactions(final BankTransactionSummarizar bankTransactionSummarizar) {
            double result = 0;
            for(final BankTransaction bankTransaction: bankTransactions) {
                result = bankTransactionSummarizar.summarize(result, bankTransaction);
            }
            return result;
        }
        public double calculateTotalInMonth(final Month month) {
            return summarizeTransactions((acc, bankTransaction) -> 
            bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
        }

        public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
            final List<BankTransaction> result = new ArrayList<>();
            for(final BankTransaction bankTransaction: bankTransactions) {
                if(bankTransactionFilter.test(bankTransaction)) {
                    result.add(bankTransaction);
                }
            }
            return bankTransactions;
        }
        public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
            return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
        }
    }
}
