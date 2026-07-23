package Excercises.TASK2;

import java.util.Scanner;

public class TASK2u {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj napis ");
        String n = s.next();
        System.out.print("Odwrócony napis: ");
        for (int i = n.length() - 1; i >= 0; i--) {
            System.out.print(n.charAt(i));
        }
    }
}
