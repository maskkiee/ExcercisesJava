package Excercises.TASK1;

import java.util.Scanner;

public class TASK1j {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj hasło: ");
        String n = s.nextLine();
        if (n.length() < 8) {
            System.out.println("Hasło jest za krótkie.");
        } else if (Character.isUpperCase(n.charAt(0))) {
            System.out.println("OK");
        } else {
                System.out.println("Hasło musi zaczynać się wielką literą");
            }
    }
}
