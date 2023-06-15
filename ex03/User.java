package ex03;

public class User {

    private final int ID;
    private int balance;
    private String name;
    private TransactionLinkedList transactionLinkedList;

    public User() {
        this.ID = UserIdsGenerator.getInstance().generateID();
        this.transactionLinkedList = new TransactionLinkedList();
        balance = 0;
    }

    public User(int balance, String name) {
        this.ID = UserIdsGenerator.getInstance().generateID();
        this.transactionLinkedList = new TransactionLinkedList();
        if (balance <= 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setBalance(int balance) {
        if (balance <= 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TransactionLinkedList getTransactionLinkedList() {
        return transactionLinkedList;
    }

    public void setTransactionLinkedList(TransactionLinkedList transactionLinkedList) {
        this.transactionLinkedList = transactionLinkedList;
    }

    @Override
    public String toString() {
        return ("\nID: " + ID +
                "\nName: " + name +
                "\nbalance: " + balance + "\n___");
    }

}
