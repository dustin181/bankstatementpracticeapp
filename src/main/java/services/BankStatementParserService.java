package services;

import models.BankTransaction;

import java.util.List;

public interface BankStatementParserService {
    List<BankTransaction> parseLinesFrom(final List<String> lines);
    BankTransaction parseFrom(final String line);

}
