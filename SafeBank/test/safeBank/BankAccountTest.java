package safeBank;

import org.junit.jupiter.api.Test;
import safeBank.exceptions.InsufficientFundsException;
import safeBank.exceptions.InvalidAmountException;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
   public  void depositShouldIncreaseBalance() throws InvalidAmountException {

        BankAccount account = new BankAccount("Daniel", new BigDecimal("10000"));

        account.deposit(new BigDecimal("5000"));

        assertEquals(0, account.getBalance().compareTo(new BigDecimal("15000")));
    }


    @Test

    public void depositShouldRejectZeroAmount(){

        BankAccount account = new BankAccount("daniel",new BigDecimal("100"));

        assertThrows(InvalidAmountException.class,() -> account.deposit(BigDecimal.ZERO));



    }


    @Test
    public void depositShouldRejectNegativeAmount(){
        BankAccount account = new BankAccount("daniel", new BigDecimal("100"));
        assertThrows(InvalidAmountException.class,()->account.deposit(new BigDecimal("-1")));

    }

    @Test
    public void invalidDepositShouldNotChangeBalance()throws InvalidAmountException{

        BankAccount account = new BankAccount("daniel", new BigDecimal("100"));

        assertThrows(InvalidAmountException.class,()->account.deposit(new BigDecimal("-1")));

        assertEquals(0,account.getBalance().compareTo(new BigDecimal("100")));
    }

    @Test
    public void withdrawShouldReduceBalance() throws InvalidAmountException,InsufficientFundsException {
        BankAccount account = new BankAccount("daniel", new BigDecimal("1000"));

        account.withdraw(new BigDecimal("300"));

        assertEquals(0, account.getBalance().compareTo(new BigDecimal("700")));
    }
    @Test
    public void withdrawShouldRejectZero() {
        BankAccount account = new BankAccount("daniel", new BigDecimal("1000"));

        assertThrows(InvalidAmountException.class, () -> account.withdraw(BigDecimal.ZERO));
    }
    @Test
    public void withdrawShouldRejectNegativeAmount() {
        BankAccount account = new BankAccount("daniel", new BigDecimal("1000"));

        assertThrows(InvalidAmountException.class,
                () -> account.withdraw(new BigDecimal("-100")));
    }


    @Test
    public void withdrawShouldRejectInsufficientFunds() {
        BankAccount account = new BankAccount("daniel", new BigDecimal("1000"));

        assertThrows(InsufficientFundsException.class, () -> account.withdraw(new BigDecimal("1500")));
    }

    @Test
    public void successfulDepositShouldBeRecordedAs_A_SuccessfulTransaction()throws InvalidAmountException{

        BankAccount account = new BankAccount("musa",new BigDecimal("1000"));
        account.deposit(new BigDecimal("500"));
        List<Transaction> transactions= account.getTransactions();

        assertEquals(1,transactions.size());



    }
}

