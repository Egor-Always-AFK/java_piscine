import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] argc) {
        int week = 1;
        String term = "42";
        Scanner scanner = new Scanner(System.in);
        String weekLine = scanner.nextLine();
        long grade = 0;
        while (week <= 18 && !weekLine.equals(term)) {
            if (!weekLine.equals("Week " + week)) {
                System.exit(putIllegalArgument());
            }
            grade *= 10;
            grade += getGrade(scanner);
            weekLine = scanner.nextLine();
            week++;
        }
        week -= 1;
        for (int i = 1; i <= week; i++) {
            vizualize((grade / getPow(i + 1, week)), i);
        }
    }

    static long getGrade(Scanner scanner) {
        long num = 0;
        for (int i = 0; i < 5; i++) {
            int tmp = scanner.nextInt();
            if (tmp <= 0 || tmp >= 10)
                putIllegalArgument();
            num *= 10;
            num += tmp;
        }
        scanner.nextLine();
        return findMin(num);
    }

    static long findMin(long arr) {
        long min = arr % 10;
        int i = 0;
        while (arr > 0) {
            if ((arr % 10) < min)
                min = arr % 10;
            arr /= 10;
        }
        return (min);
    }

    static long getPow(int index, int week) {
        int pow = 10;
        if (index != week + 1) {
            for (int i = week; i > index; i--)
                pow *= 10;
            return (pow);
        }
        else {
            return (1);
        }
    }

    static void vizualize(long min, int week) {
        System.out.print("Week " + week + " ");
        if (week > 1)
            min %= 10;
        for (int i = 0; i < min; i++)
            System.out.print("=");
        System.out.println(">");
    }

    static int putIllegalArgument() {
        System.out.println("theIllegalArgument");
        return(-1);
    }
}
