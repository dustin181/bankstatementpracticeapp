package services;

import constants.BankConstants;
import org.junit.jupiter.api.Test;

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

        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_TEST,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);

        BankStatementProcessorService calc = new BankStatementProcessorImpl(bankStatementParserService);
        assertEquals(6820, calc.calculateTotalAmount(lines));
    }

    @Test
    void calculateMonthSumJanuary() throws IOException {

        BankStatementParserService bankStatementParserService = new BankStatementParserImpl();

        BankStatementInputService bankStatementInputService = new BankStatementInputImpl();

        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_TEST,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);

        BankStatementProcessorService calc = new BankStatementProcessorImpl(bankStatementParserService);
        assertEquals(-150, calc.calculateMonthSum(lines, Month.JANUARY));
    }
}