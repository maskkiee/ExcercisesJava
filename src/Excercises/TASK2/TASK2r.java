package Excercises.TASK2;

import java.util.Scanner;

public class TASK2r {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbe");
        int x = s.nextInt();
        System.out.println("Podaj drugą liczbe");
        int y = s.nextInt();
        int wynik = 1;
        for (int i = 1; i <= y; i++) {
                wynik = wynik * x;
            }
            System.out.println(x + " do potęgi " + y + " wynosi: " + wynik);
    }
}
