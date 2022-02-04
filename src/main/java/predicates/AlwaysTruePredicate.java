package predicates;

import models.BankTransaction;

import java.util.function.Predicate;

public class AlwaysTruePredicate implements Predicate<BankTransaction> {

    @Override
    public boolean test(BankTransaction bankTransaction) {
        return true;
    }
}


