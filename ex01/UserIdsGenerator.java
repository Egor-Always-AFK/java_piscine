package ex01;

public class UserIdsGenerator {
    private static UserIdsGenerator generator;
    private static int ID;

   public  static UserIdsGenerator getInstance() {
        if (generator == null) {
            generator = new UserIdsGenerator();
        }
        return generator;
    }

    private UserIdsGenerator() {}

    public int generateID() {
        return ++ID;
    }

}
