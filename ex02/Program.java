package ex02;

import ex02.UserArrayList;

public class Program {
    public static void main(String[] args) {
        User[] users = new User[21];
        for (int i = 0; i < 21; i++) {
            users[i] = new User((i + 1000) * 2 / 5, "User" + (i + 1));
            System.out.println(users[i]);
        }

        UserArrayList usersArrayList = new UserArrayList();
        for (int i = 0; i < 21; i++) {
            usersArrayList.addUser(users[i]);
        }

        System.out.println("Все пользователи:");
        usersArrayList.printer();

        User userId = usersArrayList.getUserByID(15);
        User userIndex = usersArrayList.getUserByIndex(15);
        System.out.println("Получение пользователя с id = 15:");
        System.out.println(userId);
        System.out.println("Получение пользователя с index = 15:");
        System.out.println(userIndex);

        try {
            User userError1 = usersArrayList.getUserByID(50);
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }

        try {
            User userError2 = usersArrayList.getUserByIndex(100);
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
