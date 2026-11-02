package safeBank;

import java.math.BigDecimal;

public class Transaction {

    private TransactionType type;
    private BigDecimal amount;

    public Transaction(TransactionType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }




}
