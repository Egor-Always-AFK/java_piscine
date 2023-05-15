public class ex00 {
    public static void main(String[] args) {
        int sum =  479598;
        int ret = 0;
        ret += sum % 10;
        sum /= 10;
        ret += sum % 10;
        sum /= 10;
        ret += sum % 10;
        sum /= 10;
        ret += sum % 10;
        sum /= 10;
        ret += sum % 10;
        sum /= 10;
        ret += sum % 10;

        System.out.println(ret);
    }
}