package com.hillel.atm;

public class EmployeeController {

    public static void main(String[] args) {

        BankAccountService bankAccountService =
                new BankAccountService(1000, new TransactionRepository());
    }
}
