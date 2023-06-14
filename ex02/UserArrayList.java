package ex02;

public class UserArrayList implements UsersList{

    private int numOfUsers;
    private int maxNumOfUsers = 10;
    private User[] users = new User[maxNumOfUsers];

    @Override
    public void addUser(User newUser) {
        if (numOfUsers == maxNumOfUsers) {
            maxNumOfUsers *= 2;
            User[] tempUsers = new User[maxNumOfUsers];
            for (int i = 0; i < numOfUsers; i++) {
                tempUsers[i] = users[i];
            }
            users = tempUsers;
        }
        users[numOfUsers++] = newUser;
    }

    @Override
    public User getUserByID(int ID) {
        for (int i = 0; i < numOfUsers; i++) {
            if (users[i].getID() == ID)
                return users[i];
        }
        throw new UserNotFoundException("User with ID " + ID + " is not found\n");
    }

    @Override
    public User getUserByIndex(int index) {
           if (index < 0 || index >= maxNumOfUsers) {
               throw new UserNotFoundException("Index must be < 0 or > " + maxNumOfUsers);
           }
           return (users[index]);
    }

    @Override
    public int getNumOfUsers() {
        return numOfUsers;
    }

    public void printer() {
        for (int i = 0; i < numOfUsers; i++) {
            System.out.println((i + 1) + users[i].getName() + " balance: " + users[i].getBalance());
            System.out.println("\nID: " + users[i].getID() + "\n");
        }
    }
}
