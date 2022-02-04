package services;

import lombok.Data;
import models.BankTransaction;

import java.util.List;
import java.util.function.Predicate;

@Data
public class BankStatementProcessorImpl implements BankStatementProcessorService {

    @Override
    public double calculateTotalAmount(List<BankTransaction> transactions) {

        double total = 0;

        for(final BankTransaction bankTransaction: transactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    @Override
    public double calculateTotalAmount(List<BankTransaction> transactions, Predicate<BankTransaction> filter) {

        double total = 0;

        for(final BankTransaction bankTransaction: transactions) {
            if(filter.test(bankTransaction)){
                total += bankTransaction.getAmount();
            }

        }

        return total;
    }
}
