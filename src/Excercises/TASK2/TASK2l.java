package Excercises.TASK2;

import java.util.Scanner;

public class TASK2l {
    static void main() {
        Scanner s = new Scanner(System.in);
        int suma = 0;
        while (true) {
            System.out.println("Podaj następną liczbe. 0 kończy działanie");
            int n = s.nextInt();
            if (n == 0) {
                System.out.println("Suma wszystkich liczb to: " + suma);
                break;
            }
            if (n > 0) {
                suma = suma + n;
            }

        }
    }
}