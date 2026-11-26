package Excercises.TASK4;

import java.util.Scanner;

public class TASK4p {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sumaCyfrRek(n));
    }

    static int sumaCyfrRek(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + sumaCyfrRek(n / 10);
    }
}