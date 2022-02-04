package services;

import constants.BankConstants;
import models.BankTransaction;
import org.junit.jupiter.api.Test;
import predicates.AlwaysTruePredicate;
import predicates.TransactionInJanuaryPredicate;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankCalculatorImplTest {

    @Test
    void calculateAmount() throws IOException {

        BankStatementParserService bankStatementParserService = new BankStatementParserImpl();
        BankStatementInputService bankStatementInputService = new BankStatementInputImpl();
        BankStatementProcessorService bankStatementProcessorService = new BankStatementProcessorImpl();

        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_TEST,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);
        final List<BankTransaction> transactions = bankStatementParserService.parseLinesFrom(lines);

        assertEquals(6820, bankStatementProcessorService.calculateTotalAmount(transactions));
    }

    @Test
    void calculateAmountWithTruePredicate() throws IOException {

        BankStatementParserService bankStatementParserService = new BankStatementParserImpl();
        BankStatementInputService bankStatementInputService = new BankStatementInputImpl();
        BankStatementProcessorService bankStatementProcessorService = new BankStatementProcessorImpl();

        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_TEST,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);
        final List<BankTransaction> transactions = bankStatementParserService.parseLinesFrom(lines);

        assertEquals(6820, bankStatementProcessorService.calculateTotalAmount(transactions, new AlwaysTruePredicate()));
    }

    @Test
    void calculateAmountWithJanuaryPredicate() throws IOException {

        BankStatementParserService bankStatementParserService = new BankStatementParserImpl();
        BankStatementInputService bankStatementInputService = new BankStatementInputImpl();
        BankStatementProcessorService bankStatementProcessorService = new BankStatementProcessorImpl();

        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_TEST,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);
        final List<BankTransaction> transactions = bankStatementParserService.parseLinesFrom(lines);

        assertEquals(-150, bankStatementProcessorService.calculateTotalAmount(transactions, new TransactionInJanuaryPredicate()));
    }
}