package Excercises.TASK2;

import java.util.Scanner;

public class TASK2p {
    static void main() {
    Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int n = s.nextInt();
        int iloscCyfr = 0;
        while (n > 0) {
            n = n/10;
            iloscCyfr = iloscCyfr + 1;
        }
        System.out.println("Liczba ma " + iloscCyfr + " cyfr.");
    }
}
