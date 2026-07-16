package Excercises.TASK1;

import java.util.Scanner;

public class TASK1k {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj rok: ");
        int n = s.nextInt();
        boolean ifPrzestepny = (n % 4 == 0);
        if (ifPrzestepny) {
            System.out.println("Rok jest przestępny.");
        } else {
            System.out.println("Rok nie jest przestępny.");
            }
    }
}
