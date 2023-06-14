package ex01;

public class User {

    private final int ID;
    private int balance;
    private String name;

    public User() {
        this.ID = UserIdsGenerator.getInstance().generateID();
        balance = 0;
    }

    public User(int balance, String name) {
        this.ID = UserIdsGenerator.getInstance().generateID();
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

    @Override
    public String toString() {
        return ("\nID: " + ID +
                "\nName: " + name +
                "\nbalance: " + balance + "\n___");
    }

}
