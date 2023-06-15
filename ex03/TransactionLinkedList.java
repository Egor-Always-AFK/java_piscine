package ex03;

import java.util.UUID;

public class TransactionLinkedList implements TransactionList {

    private Node first;
    private Node last;
    private int size;

    public TransactionLinkedList() {}


    @Override
    public void addTransaction(Transaction transaction) {
        final Node tmp = last;
        final Node node = new Node(null, tmp, transaction);
        if (tmp == null) {
            first = node;
        } else {
            tmp.next = node;
        }
        size++;
    }

    @Override
    public void removeTransactionByID(UUID uuid) {
        if (uuid == null) {
            throw new TransactionNotFoundException("Cannot be remove transaction with 'null' UUID.");
        }
        for (Node node = first; node != null; node = node.next) {
            if (node.transaction != null && uuid.equals(node.transaction.getUuid())) {
                final Node next = node.next;
                final Node prev = node.prev;

                if (prev == null) {
                    first = next;
                } else {
                    prev.next = next;
                    node.prev = null;
                }

                if (next == null) {
                    last = prev;
                } else {
                    next.prev = prev;
                    node.next = null;
                }
                node.transaction = null;
                size--;
                return;
            }
        }
        throw new TransactionNotFoundException("Transaction with UUID: " + uuid + " not found");
    }

    @Override
    public Transaction[] toArray() {
        if (size == 0) {
            return null;
        }
        Transaction[] transactions = new Transaction[this.size];
        int i = 0;
        for (Node node = this.first; node != this.last; node = node.next) {
            transactions[i++] = node.transaction;
        }
        return  transactions;
    }

    public int getSize() {
        return size;
    }
}
