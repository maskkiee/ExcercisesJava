package Excercises.TASK3;

import java.util.Scanner;

public class TASK3u {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the phrase: ");
        String phrase = scanner.nextLine();

        String cleanPhrase = phrase.toLowerCase().replace(" ", "");

        String reverse = "";
        for (int i = cleanPhrase.length() - 1; i >= 0; i--) {
            reverse += cleanPhrase.charAt(i);
        }
        if (cleanPhrase.equals(reverse)) {
            System.out.println("The phrase is a palindrome.");
        } else {
            System.out.println("The phrase is not a palindrome.");
        }
    }
}
