import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int steps = 0;
        boolean isPrime = true;
        int sqrt;

        if (num <= 1) {
            System.exit(puttIllegalArgument());
        } else if (num == 2) {
            System.out.println(isPrime + " " + 1);
        } else {
            sqrt = sqrt(num);
            for (int i = 2; i <= sqrt + 1; i++) {
                steps++;
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(isPrime + " " + steps);
        System.exit(0);
    }

    private static int puttIllegalArgument() {
        System.err.println("theIllegalArgument");
        return (-1);
    }

    private static int sqrt(int num) {
        long start = 1;
        long end = num;
        long ret = 0;
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == num) {
                return ((int) mid);
            } else if (mid * mid < num) {
                start = mid + 1;
                ret = mid;
            } else {
                end = mid - 1;
            }
        }
        return (int) ret;
    }
}
