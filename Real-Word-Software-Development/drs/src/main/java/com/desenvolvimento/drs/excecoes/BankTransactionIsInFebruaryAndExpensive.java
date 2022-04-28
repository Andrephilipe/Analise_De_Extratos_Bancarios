package com.desenvolvimento.drs.excecoes;

import java.time.Month;

import com.desenvolvimento.drs.BankTransaction;
import com.desenvolvimento.drs.BankTransactionFilter;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
    }
    
    /*final List<BankTransaction> transactions = bankStatementProcessor.findTransactions(new BankTransactionIsInFebruaryAndExpensive());
    exemplo com Lambda
    final List<BankTransaction> transactions2 = BankStatementProcessor.findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY 
    && bankTransaction.getAmount() >= 1_000);*/
}
