import com.google.inject.Inject;
import constants.BankConstants;
import services.BankStatementProcessorService;
import services.BankStatementInputService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Analyzer {


    private final BankStatementInputService bankStatementInputService;
    private final BankStatementProcessorService bankStatementProcessorService;

    @Inject
    public Analyzer(BankStatementInputService bankStatementInputService, BankStatementProcessorService bankStatementProcessorService){
        this.bankStatementInputService = bankStatementInputService;
        this.bankStatementProcessorService = bankStatementProcessorService;
    }

    public void compute() throws IOException {
        final Path path = bankStatementInputService.getPath(BankConstants.RESOURCES_MAIN,BankConstants.BANK_DATA_SIMPLE_CSV);
        final List<String> lines = bankStatementInputService.getLines(path);

        double total = bankStatementProcessorService.calculateTotalAmount(lines);

        System.out.println("The total for all transactions is " + total);
    }




}
