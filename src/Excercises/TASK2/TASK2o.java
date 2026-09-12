package Excercises.TASK2;

import java.util.Scanner;

public class TASK2o {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int n = s.nextInt();
        int silnia = 1;
        for (int i = 1; i <= n; i++) {
            silnia *= i;
        }
        System.out.println(silnia);
    }
}
