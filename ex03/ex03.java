import java.util.Objects;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] argc) {
        int week = 1;
        String term = "42";
        Scanner scanner = new Scanner(System.in);
        String weekLine = scanner.nextLine();
        int[][] arr = new int[18][5];
        while ((week <= 3) || (weekLine.equals(term))) {
            if (!weekLine.equals("Week " + week))
                putIllegalArgument();
            String str = scanner.nextLine();
            arr[week] = parsStr(str.split(" "));
            weekLine = scanner.nextLine();
            week++;
        }
        for (int i = 1; i != week; i++)
            vizualize(findMin(arr[i - 1]), i);
    }


    static int[] parsStr(String[] str) {
        int[] ret = new int[5];
        for (int i = 0; i != 5; i++) {
            ret[i] = str[i].charAt(0) - '0';
        }
        return (ret);
    }
    static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i != arr.length; i++) {
            if (min < arr[i])
                min = arr[i];
        }
        return (min);
    }

    static void vizualize(int min, int week) {
        System.out.print("Week " + week + " ");
        for (int i = 1; i != min; i++)
            System.out.print("=");
        System.out.println(">");
    }

    static void putIllegalArgument() {
        System.out.println("theIllegalArgument");
        System.exit(-1);
    }
}
