package ex00;

public class User {

    private int ID;
    private int balance;
    private String name;

    public User(int id, int balance, String name) {
        this.ID = id;
        if (balance <= 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
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
