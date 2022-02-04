package services;

import models.BankTransaction;

import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

public interface BankStatementProcessorService {

    double calculateTotalAmount(List<BankTransaction> transactions);
    double calculateTotalAmount(List<BankTransaction> transactions, Predicate<BankTransaction> filter);

}
