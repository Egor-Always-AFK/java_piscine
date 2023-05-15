import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num <= 1) {
            err();
        }
        else {
            int[] ret = sieve(num);
            boolean bool;
            if (ret[0] == 1)
                bool = true;
            else
                bool = false;
            System.out.print(bool + " ");
            System.out.println(ret[1]);
        }
    }

    static void err() {
        System.err.println("theIllegalArgument");
        System.exit(-1);
    }
    static int[] sieve(int num) {
        boolean[] arr = new boolean[num];
        Arrays.fill(arr, true);
        int iter = 0;
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                iter++;
                for (int j = i * i; j < num; j += i)
                    arr[j] = false;
            }
        }
        if (arr[num - 1]) {
            int[] ret = {1, iter};
            return (ret);
        }
        else {
            int[] ret = {0, iter};
            return (ret);
        }
    }
}
