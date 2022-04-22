package com.desenvolvimento.drs.versoes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class BankTransactionAnalizerSimpleV2 {

    private static final String RESOURCES = "C:/Users/andre.p.cassiano/Java - Estudos da linguagem/desenvolvimento-real-de-software/analise_de_extratos_bancarios/Real-Word-Software-Development/drs/src/main/resources/";
    public static void main(final String[] args) throws Exception {
    
        final Path path = Paths.get(RESOURCES + "banck-extract.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for(final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }

        }

        System.out.println("The total for all transactions is January" + total );
    }
}

