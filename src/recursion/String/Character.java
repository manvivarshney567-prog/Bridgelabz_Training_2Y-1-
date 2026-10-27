package recursion.String;

import java.util.Scanner;

public class Character {
    public static int countChar(String str, char ch, int index) {

        if (index == str.length()) {
            return 0;
        }

        if (str.charAt(index) == ch) {
            return 1 + countChar(str, ch, index + 1);
        }

        return countChar(str, ch, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter character to count: ");
        char ch = sc.next().charAt(0);

        int count = countChar(str, ch, 0);

        System.out.println("Occurrences: " + count);

    }
}


