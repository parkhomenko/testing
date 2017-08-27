package com.hillel.atm;

import java.util.LinkedList;
import java.util.List;

public class BankAccountService {

  private int totalAmount;
  private int transactionId;
  private List<Transaction> transactions;

  private int limit;

  public BankAccountService(int totalAmount) {
    this.totalAmount = totalAmount;
    transactionId = 0;
    limit = 0;
    transactions = new LinkedList<>();
  }

  public void withdrawMoney(int amount) {
    totalAmount = totalAmount - amount;

    if (totalAmount < 0) {
      totalAmount = 0;
    }

    transactionId++;
    Transaction transaction = new Transaction(transactionId, Operation.WITHDRAWAL, amount,
        totalAmount);
    transactions.add(transaction);
  }

  public void refillMoney(int amount) {
    totalAmount = totalAmount + amount;

    transactionId++;
    Transaction transaction = new Transaction(transactionId, Operation.REFILL, amount,
        totalAmount);
    transactions.add(transaction);
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setLimit(int amount) {
    this.limit = amount;
  }

  public boolean limitReached() {
    return totalAmount <= limit;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
}
