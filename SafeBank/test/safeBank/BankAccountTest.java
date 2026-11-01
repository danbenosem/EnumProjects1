package safeBank;

import org.junit.jupiter.api.Test;
import safeBank.exceptions.InvalidAmountException;

import java.math.BigDecimal;

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
}

