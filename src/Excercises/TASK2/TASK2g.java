package Excercises.TASK2;

import java.util.Scanner;

public class TASK2g {
    public static void main() {
    Scanner s = new Scanner(System.in);
    String kod = "java123";
    System.out.println("Wczytaj napis:");
    String n = s.next();
    while (!n.equals(kod)) {
        System.out.println("Podaj hasło ponownie.");
        n = s.next();
        if (n.equals(kod)) {
            System.out.println("Zalogowano");
            }
        }

    }
}

