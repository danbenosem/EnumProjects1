package safeBank;

import safeBank.exceptions.InsufficientFundsException;
import safeBank.exceptions.InvalidAmountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountName;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public BankAccount(String accountName,  BigDecimal balance) {
         if( accountName==null||accountName.isBlank() ){
             throw new IllegalArgumentException("name cannot be blank");
         }
         this.accountName = accountName;

         if(balance.compareTo(BigDecimal.ZERO)<0){
             throw new IllegalArgumentException("balance cannot be negative");
         }
         this.balance = balance;

       this.transactions=new ArrayList<>();

    }

    public void deposit(BigDecimal bigDecimal) throws InvalidAmountException {
        if(bigDecimal==null)throw new InvalidAmountException("Amount cannot be null");
      if (bigDecimal.compareTo(BigDecimal.ZERO)<0) throw new InvalidAmountException ("You cannot deposit negative amount");
     if(bigDecimal.compareTo(BigDecimal.ZERO)==0) throw new InvalidAmountException("You cannot deposit Zero Amount");

     balance = balance.add(bigDecimal);
     Transaction transaction = new Transaction(TransactionType.DEPOSIT,bigDecimal);
     transactions.add(transaction);



    }

    public BigDecimal getBalance() {
          return balance;
    }

    public void withdraw(BigDecimal bigDecimal) throws InvalidAmountException,InsufficientFundsException {
              if(bigDecimal.compareTo(BigDecimal.ZERO)<0) throw new InvalidAmountException("Invalid amount");
              if(bigDecimal.compareTo(BigDecimal.ZERO)==0)throw new InvalidAmountException("Invalid amount");
              if(bigDecimal.compareTo(balance)>0)throw new InsufficientFundsException("InsufficientFunds");

              balance=balance.subtract(bigDecimal);

              Transaction transaction = new Transaction(TransactionType.WITHDRAWAL,bigDecimal);
              transactions.add(transaction);

    }

    public List<Transaction> getTransactions() {


        return List.copyOf(transactions);
    }
}
