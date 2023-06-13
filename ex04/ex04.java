import java.util.Scanner;

public class ex04 {

    private static final int MAX_CHAR_CODES = 65_535;
    private static final int MAX_TOP_CHARS = 10;
    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        short[] charCount = getCharOccurences(input);
        char[] topTenChars = getTopTenChars(charCount);
        printer(topTenChars, charCount);
    }

    private static  short[] getCharOccurences(String str) {
        short[] ret = new short[MAX_CHAR_CODES];
        char[] inpArr = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            ret[inpArr[i]]++;
        }
        return (ret);
    }

    private static char[] getTopTenChars(short[] parsedInput) {
        char[] ret = new char[10];

        for (int i = 0; i < MAX_CHAR_CODES; i++) {
            short iCharCount = parsedInput[i];
            if (iCharCount > 0) {
                for (int j = 0; j < MAX_TOP_CHARS; j++) {
                    if (parsedInput[ret[j]] < iCharCount) {
                        ret = insertCharAt(ret, (char) i, j);
                        break;
                    }
                }
            }
        }
        return (ret);
    }

    private static char[] insertCharAt(char[] base, char c, int index) {
        char[] ret = new char[MAX_TOP_CHARS];
        for (int i = 0; i < index; i++) {
            ret[i] = base[i];
        }
        ret[index] = c;
        for (int i = index + 1; i < MAX_TOP_CHARS; i++) {
            ret[i] = base[i - 1];
        }
        return (ret);
    }

    private static void printer(char[] topTenChars, short[] charCount) {
        short max = charCount[topTenChars[0]];
        byte maxHeight = (byte) (max <= 10 ? max : 10);
        byte totalLines = (byte) (2 + maxHeight);
        byte[] graphs = new byte[MAX_TOP_CHARS];

        for (int i = 0; i < MAX_TOP_CHARS; i++) {
            if (max <= 10) {
                graphs[i] = (byte) charCount[topTenChars[i]];
            } else {
                graphs[i] = (byte) (charCount[topTenChars[i]] * 10 / max);
            }
        }
        System.out.println();
        for (int i = 0; i < totalLines; i++) {
            for (int j = 0; j < MAX_TOP_CHARS; j++) {
                if (topTenChars[j] != 0) {
                    if (i + graphs[j] + 2 == totalLines) {
                        System.out.printf("%3d", charCount[topTenChars[j]]);
                    } else if (i == totalLines - 1) {
                        System.out.printf("%3c", topTenChars[j]);
                    } else if (i + graphs[j] >= maxHeight) {
                        System.out.printf("%3c", '#');
                    }
                    if (j != MAX_TOP_CHARS - 1 && topTenChars[j + 1] != 0 && i + graphs[j + 1] >= maxHeight) {
                        System.out.printf("%c", ' ');
                    }
                }
            }
            System.out.println();
        }
    }
}
