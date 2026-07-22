package Excercises.TASK2;

import java.util.Scanner;

public class TASK2t {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe ocen");
        int n = s.nextInt();
        double suma = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Podaj ocenę nr " + i + ": ");
            double ocena = s.nextDouble();
            suma += ocena;
        }
        double srednia = suma / n;
        System.out.println("Srednia: " + srednia);
    }
}
