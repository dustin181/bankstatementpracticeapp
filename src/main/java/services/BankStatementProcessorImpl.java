package services;

import com.google.inject.Inject;
import models.BankTransaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementProcessorImpl implements BankStatementProcessorService {

    private final BankStatementParserService bankStatementParserService;

    @Inject
    public BankStatementProcessorImpl(BankStatementParserService bankStatementParserService) {
        this.bankStatementParserService = bankStatementParserService;
    }

    @Override
    public double calculateTotalAmount(List<String> lines) {

        List<BankTransaction> bankTransactions = bankStatementParserService.parseLinesFrom(lines);
        double total = 0;

        for(final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    @Override
    public double calculateMonthSum(List<String> lines, Month aggregationMonth) {

        List<BankTransaction> bankTransactions = bankStatementParserService.parseLinesFrom(lines);
        double total = 0;

        for(final BankTransaction bankTransaction: bankTransactions) {
            final LocalDate date = bankTransaction.getDate();
            final Month transactionMonth = date.getMonth();
            if(transactionMonth == aggregationMonth){
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }
}
