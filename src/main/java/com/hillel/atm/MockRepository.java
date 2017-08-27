package com.hillel.atm;

import java.util.List;

public class MockRepository implements Repository {

    @Override
    public void addTransaction(Operation operation, int amount, int leftAmount) {
    }

    @Override
    public List<Transaction> getTransactions() {
        return null;
    }
}
