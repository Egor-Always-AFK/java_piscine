package ex01;

import ex01.User;

public class Program {
    public static void main(String[] args) {
        User[] users = new User[21];
        for (int i = 0; i < 21; i++) {
            users[i] = new User((i + 1000) * 2 / 5, "User" + (i + 1));
            System.out.println(users[i]);
        }
    }
}
