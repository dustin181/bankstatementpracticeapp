package services;

import models.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementParserImpl implements BankStatementParserService {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines) {
            bankTransactions.add(parseFrom(line));
        }

        return bankTransactions;
    }

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }
}
