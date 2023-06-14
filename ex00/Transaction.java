package ex00;

import java.util.UUID;

public class Transaction {
    private UUID uuid;

    private User recipient;
    private User sender;
    private Category category;
    private int amount;

    enum Category {
        DEBIT,
        CREDIT,
    }


    public Transaction(User recipient, User sender, Category category, int amount) {
        this.uuid = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (category == Category.CREDIT && (amount > 0 || sender.getBalance() < amount)) {
            this.amount = 0;
        } else if (category == Category.DEBIT && (amount < 0 || recipient.getBalance() < amount)) {
            this.amount = 0;
        } else {
            this.amount = amount;
            changeBalance(amount);
        }
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    private void changeBalance(int amount) {
        if (category == Category.CREDIT) {
            sender.setBalance(sender.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
        }
        else {
            sender.setBalance(sender.getBalance() + amount);
            recipient.setBalance(recipient.getBalance() - amount);
        }
    }

    @Override
    public String toString() {
        return ("\nTransaction: " +
                "\nID: " + uuid +
                "\nRecipient: " + recipient +
                "\nSender: " + sender +
                "\nCategory: " + category +
                "\nAmount: " + amount);
    }
}
