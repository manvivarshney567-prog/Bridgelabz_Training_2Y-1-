package recursion.String;

import java.util.Scanner;

public class ReverseString {
    public static String reverse(String str, int index) {
        if (index < 0) {
            return "";
        }

        return str.charAt(index) + reverse(str, index - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = reverse(str, str.length() - 1);

        System.out.println("Reversed string: " + result);

    }
}
