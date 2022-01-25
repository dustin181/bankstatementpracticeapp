package services;

import java.time.Month;
import java.util.List;

public interface BankStatementProcessorService {

    double calculateTotalAmount(List<String> lines);

    double calculateMonthSum(List<String> lines, Month month);
}
