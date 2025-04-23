package banking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BankingSystemTest {
    private Account account;

    @Mock
    private Account mockAccount;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        account = new Account(1000.0);
    }

    @ParameterizedTest
    @CsvSource({"200,1200", "500,1500", "1000,2000"})
    void testDeposit(double amount, double expectedBalance) {
        account.deposit(amount);
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"200,800", "500,500", "1000,0"})
    void testWithdraw(double amount, double expectedBalance) {
        account.withdraw(amount);
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(2000), "Insufficient funds");
    }

    @Test
    void testDepositException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100), "Deposit amount must be positive");
    }

    @Test
    void testTransferFunds() {
        Account recipient = new Account(500);
        account.transferFunds(recipient, 300);
        assertEquals(700, account.getBalance(), 0.001);
        assertEquals(800, recipient.getBalance(), 0.001);
    }

    @Test
    void testTransferFundsException() {
        Account recipient = new Account(500);
        assertThrows(IllegalArgumentException.class, () -> account.transferFunds(recipient, 2000), "Insufficient funds");
    }

    @Test
    void testMockedAccountDeposit() {
        doNothing().when(mockAccount).deposit(anyDouble());
        mockAccount.deposit(500);
        verify(mockAccount, times(1)).deposit(500);
    }
}
