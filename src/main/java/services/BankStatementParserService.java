package services;

import models.BankTransaction;

import java.util.List;

public interface BankStatementParserService {
    List<BankTransaction> parseLinesFrom(final List<String> lines);
    // --Commented out by Inspection (1/24/2022 7:30 PM):BankTransaction parseFrom(final String line);

}
