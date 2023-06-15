package ex03;

import java.util.UUID;

public interface TransactionList {
    void addTransaction(Transaction transaction);

    void removeTransactionByID(UUID uuid);

    Transaction[] toArray();
}
