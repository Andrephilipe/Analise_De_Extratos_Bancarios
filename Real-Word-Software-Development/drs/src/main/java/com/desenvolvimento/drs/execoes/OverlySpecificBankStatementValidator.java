package com.desenvolvimento.drs;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

import javax.print.DocFlavor.STRING;

public class OverlySpecificBankStatementValidator {
    private String description;
    private String date;
    private String amount;

    public OverlySpecificBankStatementValidator(final String description, final String date, final String amount) {

        this.description = Objects.requireNonNull(description);
        this.date = Objects.requireNonNull(description);
        this.amount = Objects.requireNonNull(description);
    }

    public boolean validate()  throws DescriptionTooLongException, InvalidDateFormat, DateInTheFutureException, InvalidAmountException {

        if(this.description.length() > 100) {
            throw new DescriptionTooLongException();
        }

        final LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(this.date);
        }
        catch(DateTimeException e) {
            throw new InvalidDateFormat();
        }
        if(parsedDate.isAfter(LocalDate.now())) throw new DateInTheFutureException();
        try {
            Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            //TODO: handle exception
            throw new InvalidAmountException();
        }

        return true;
    }
    
}
