package Excercises.TASK2;

import java.util.Scanner;

public class TASK2c {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int suma = 0;
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        System.out.println(suma);
        }
    }