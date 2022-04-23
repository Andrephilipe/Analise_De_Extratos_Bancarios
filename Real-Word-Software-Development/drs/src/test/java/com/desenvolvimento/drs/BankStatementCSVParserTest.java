package com.desenvolvimento.drs;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCVSParser();

    @Test
    public void shouldParseOneCorrectLine() {

        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        Assertions.assertEquals(expected, getDate(), result.getDate());
        Assertions.assertEquals(expected, getAmount(), result.getAmount(), tolerance);
        Assertions.assertEquals(expected, getDescription(), result.getDescription());
    }

}
