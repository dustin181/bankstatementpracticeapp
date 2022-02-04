import com.google.inject.Inject;
import constants.BankConstants;
import models.BankTransaction;
import services.BankStatementParserService;
import services.BankStatementProcessorService;
import services.BankStatementInputService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Analyzer {


    private final BankStatementInputService bankStatementInputService;
    private final BankStatementProcessorService bankStatementProcessorService;
    private final BankStatementParserService bankStatementParserService;

    @Inject
    public Analyzer(BankStatementInputService bankStatementInputService, BankStatementProcessorService bankStatementProcessorService, BankStatementParserService bankStatementParserService){
        this.bankStatementInputService = bankStatementInputService;
        this.bankStatementProcessorService = bankStatementProcessorService;
        this.bankStatementParserService = bankStatementParserService;
    }

    public void compute() throws IOException {
        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_MAIN,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);
        final List<BankTransaction> transactions = bankStatementParserService.parseLinesFrom(lines);

        double total = bankStatementProcessorService.calculateTotalAmount(transactions);

        System.out.println("The total for all transactions is " + total);
    }




}
