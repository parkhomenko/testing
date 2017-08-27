package com.hillel.atm;

public class BankAccountService {

  private int totalAmount;
  private int limit;
  private Repository transactionRepository;

  public BankAccountService(int totalAmount, Repository repository) {
    this.totalAmount = totalAmount;
    limit = 0;
    transactionRepository = repository;
  }

  public void withdrawMoney(int amount) {
    if (totalAmount - amount < 0) {
      throw new NotEnoughMoneyException("You have not enough money");
    }

    totalAmount = totalAmount - amount;

    transactionRepository.addTransaction(Operation.WITHDRAWAL, amount, totalAmount);
  }

  public void refillMoney(int amount) {
    totalAmount = totalAmount + amount;

    transactionRepository.addTransaction(Operation.REFILL, amount, totalAmount);
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

  public int getLimit() {
    return limit;
  }
}
