package com.hillel.atm;

import java.util.LinkedList;
import java.util.List;

public class TransactionRepository implements Repository {

    private int transactionId;
    private List<Transaction> transactions;

    public TransactionRepository() {
        transactions = new LinkedList<>();
    }

    @Override
    public void addTransaction(Operation operation, int amount, int leftAmount) {
        Transaction transaction = new Transaction(transactionId++, operation, amount, leftAmount);
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
