import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ex02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int coffeeRequest = 0;
        while (num != 42) {
            if (numPrimeChecker(digitsSum(num))) {
                coffeeRequest++;
            }
            num = scanner.nextInt();
        }
        System.out.println("Count of coffee-request - " + coffeeRequest);
    }

    private static boolean numPrimeChecker(int num) {
        int sqrt = 0;

        if (num <= 1) {
            System.exit(puttIllegalArgument());
        } else if (num == 2) {
            return (true);
        } else {
            sqrt = sqrt(num);
            for (int i = 2; i <= sqrt + 1; i++) {
                if (num % i == 0) {
                    return (false);
                }
            }
        }
        return (true);
    }

    private static int digitsSum(int num) {
        int result = 0;

        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return (result);
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
