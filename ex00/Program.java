package ex00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        User user1 = new User(1, 50000, "Valeriy");
        User user2 = new User(2, 15000, "Nikolay" );

        System.out.println("Вывод информации о пользователях до проведения операций:\n");
        System.out.println(user1 + "\n");
        System.out.println(user2);

        System.out.print("___\nИнформация об операциях:\n");
        Transaction transaction1 = new Transaction(user1, user2, Transaction.Category.DEBIT, 5000);
        System.out.println(transaction1 + "\n");
        Transaction transaction2 = new Transaction(user1, user2, Transaction.Category.CREDIT, 1500);
        System.out.println(transaction2 + "\n");
        Transaction transaction3 = new Transaction(user2, user1, Transaction.Category.DEBIT, 1000);
        System.out.println(transaction3 + "\n");
        Transaction transaction4 = new Transaction(user2, user1, Transaction.Category.CREDIT, 1500);
        System.out.println(transaction4 + "\n");

        System.out.println("___\nВывод информации о пользователях после проведения операций:\n");
        System.out.println(user1 + "\n");
        System.out.println(user2);

    }

}
