package com.hillel.atm;

import java.util.List;

public interface Repository {
    void addTransaction(Operation operation, int amount, int leftAmount);

    List<Transaction> getTransactions();
}
