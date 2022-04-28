package com.iteratrlearning.realsoftwaredevelopment;

import java.io.IOException;

public class MainAplication {
    
    public static void main(String[] args) throws IOException{
        
        final BankStatementAnalizer bankStatementAnalizer = new BankStatementAnalizer();

        final BankStatementParser bankStatementParser = new BankStatementCVSParser();

        bankStatementAnalizer.analyze("bank-data-simple.csv", bankStatementParser);
        
    }
}
