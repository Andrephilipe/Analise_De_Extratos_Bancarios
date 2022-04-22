package com.desenvolvimento.drs.versoes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class BankTransactionAnalizerSimpleORIGIN {

    private static final String RESOURCES = "C:/Users/andre.p.cassiano/Java - Estudos da linguagem/desenvolvimento-real-de-software/analise_de_extratos_bancarios/Real-Word-Software-Development/drs/src/main/resources/";
    public static void main(final String[] args) throws Exception {
    
        final Path path = Paths.get(RESOURCES + "banck-extract.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        for(final String line : lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total );
    }
}

