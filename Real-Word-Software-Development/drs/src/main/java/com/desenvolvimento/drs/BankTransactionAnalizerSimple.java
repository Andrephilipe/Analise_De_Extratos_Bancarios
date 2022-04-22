package com.desenvolvimento.drs;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BankTransactionAnalizerSimple {

    private static final String RESOURCES = "C:/Users/andre.p.cassiano/Java - Estudos da linguagem/desenvolvimento-real-de-software/analise_de_extratos_bancarios/Real-Word-Software-Development/drs/src/main/resources/";
    public static void main(final String[] args) throws Exception {
        final BankStatementCVSParser bankStatementParser = new BankStatementCVSParser();
        final String fileName = "banck-extract.csv";
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        System.out.println("test" + calculateTotalAmount(bankTransactions));
        System.out.println("test" + selectInMonth(bankTransactions, Month.JANUARY));

    }
    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {

        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}

