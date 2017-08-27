package com.hillel.atm;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

    BankAccountService bankAccountService;

    @Mock
    private TransactionRepository repository;

    @Rule
    public ExpectedException expectedException =
            ExpectedException.none();

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
        bankAccountService =
                new BankAccountService(1000, repository);
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @Test
    public void totalAmountShouldBe1000() {
        assertEquals(1000, bankAccountService.getTotalAmount());
    }

    @Test
    public void limitShouldBeZero() {
        assertEquals(0, bankAccountService.getLimit());
    }

    @Test
    public void shouldHaveInTotal950WhenWithdraw50() {

        bankAccountService.withdrawMoney(50);

        assertEquals(950, bankAccountService.getTotalAmount());
        assertThat(bankAccountService.getTotalAmount(), is(950));

        verify(repository, times(1)).addTransaction(any(), anyInt(), anyInt());
    }

    @Test
    public void shouldHaveInTotal1100WhenRefillBy100() {
        bankAccountService.refillMoney(100);

        assertEquals(1100, bankAccountService.getTotalAmount());
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void shouldThrowExceptionIfAtmHasNotEnoughMoney() {
        bankAccountService.withdrawMoney(2000);
    }

    @Test
    public void shouldReturnSomeMessage() {
        expectedException.expect(NotEnoughMoneyException.class);
        expectedException.expectMessage("You have not enough money");
        bankAccountService.withdrawMoney(2000);
    }

    @Ignore
    @Test(timeout = 100)
    public void shouldTakeSomeTime() {
        for (int i = 0; i < 10000000; i++) {
            bankAccountService.refillMoney(1);
        }
    }
}
