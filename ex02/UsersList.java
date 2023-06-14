package ex02;

public interface UsersList {

    void addUser(User newUser);

    User getUserByID(int ID);

    User getUserByIndex(int index);

    int getNumOfUsers();
}
