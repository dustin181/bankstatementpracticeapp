package predicates;

import models.BankTransaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;

public class TransactionInJanuaryPredicate implements Predicate<BankTransaction> {

    @Override
    public boolean test(BankTransaction bankTransaction) {

        final LocalDate date = bankTransaction.getDate();
        final Month transactionMonth = date.getMonth();

        return Month.JANUARY == transactionMonth;
    }
}


