package com.hillel.atm;

public class Transaction {

  private int transactionId;
  private Operation operation;
  private int amount;
  private int leftAmount;

  public Transaction(int transactionId, Operation operation, int amount, int leftAmount) {
    this.transactionId = transactionId;
    this.operation = operation;
    this.amount = amount;
    this.leftAmount = leftAmount;
  }

  public int getTransactionId() {
    return transactionId;
  }

  public Operation getOperation() {
    return operation;
  }

  public int getAmount() {
    return amount;
  }

  public int getLeftAmount() {
    return leftAmount;
  }
}
