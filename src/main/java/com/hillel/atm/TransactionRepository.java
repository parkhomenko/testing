package com.hillel.atm;

import java.util.LinkedList;
import java.util.List;

public class TransactionRepository {

    private int transactionId;
    private List<Transaction> transactions;

    public TransactionRepository() {
        transactions = new LinkedList<>();
    }

    public void addTransaction(Operation operation, int amount, int leftAmount) {
        Transaction transaction = new Transaction(transactionId++, operation, amount, leftAmount);
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
