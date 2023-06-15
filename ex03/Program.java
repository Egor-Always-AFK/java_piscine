package ex03;



import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User(5000, "User1");
        User user2 = new User(1000, "User2");

        TransactionLinkedList listOfTransactionUser1 = user1.getTransactionLinkedList();

        Transaction tr1 = new Transaction(user1, user2, Transaction.Category.CREDIT, -300);
        Transaction tr2 = new Transaction(user1, user2, Transaction.Category.CREDIT, -500);
        Transaction tr3 = new Transaction(user1, user2, Transaction.Category.DEBIT, 300);
        Transaction tr4 = new Transaction(user1, user2, Transaction.Category.DEBIT, 500);

        listOfTransactionUser1.addTransaction(tr1);
        listOfTransactionUser1.addTransaction(tr2);
        listOfTransactionUser1.addTransaction(tr3);
        listOfTransactionUser1.addTransaction(tr4);

        System.out.println("User1 make " + user1.getTransactionLinkedList().getSize() + " transact.");

        System.out.println("Delete third transact");
        listOfTransactionUser1.removeTransactionByID(tr3.getUuid());


        System.out.println("Попытаемся удалить несуществующую транзакцию: ");
        try {
            listOfTransactionUser1.removeTransactionByID(UUID.randomUUID());
        } catch (TransactionNotFoundException exception) {
            exception.printStackTrace();
        }

        System.out.println("Переведем список в массив и выведем на печать: ");
        Transaction[] arrayOfTransaction = listOfTransactionUser1.toArray();

        for (Transaction item : arrayOfTransaction) {
            System.out.println((item.toString()));
        }
    }
}