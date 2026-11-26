package Excercises.TASK1;

import java.util.Scanner;

public class TASK1a {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj wiek: ");
        int n = s.nextInt();
        if (n >= 18) {
            System.out.println("Jesteś pełnoletni.");
        } else System.out.println("Nie jesteś pełnoletni");

    }
}
