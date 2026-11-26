package Excercises.TASK1;

import java.util.Scanner;

public class TASK1b {

    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        int n = s.nextInt();
        if ((n % 2) == 0) {
            System.out.println("Liczba jest parzysta.");
        } else {
            System.out.println("Liczba jest nieparzysta.");
        }

    }
}