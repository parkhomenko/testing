package com.hillel.atm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BankAccountServiceTest.class,
        HelloWorldTest.class
    }
)
public class TestGroup {
}
