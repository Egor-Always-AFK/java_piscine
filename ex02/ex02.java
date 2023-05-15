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
            int sum = digitsSum(num);
            if (!sieve(sum)) {
                coffeeRequest++;
            }
            num = scanner.nextInt();
        }
        System.out.println("Count of coffee-request - " + coffeeRequest);
    }

    static int digitsSum(int num) {
        int sum = 0;
        int tmp = num;
        while (tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return (sum);
    }
    static boolean sieve(int num) {
        boolean[] arr = new boolean[num];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                for (int j = i + i; j < num; j += i)
                    arr[j] = false;
            }
        }
        return arr[num - 1];
    }
}
